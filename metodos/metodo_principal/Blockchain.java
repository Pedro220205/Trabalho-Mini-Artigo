package metodo_principal;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private int difficulty;
    private List<Block> blocks;

    public Blockchain(int difficulty) {
        this.difficulty = difficulty;
        blocks = new ArrayList<>();

        Block genesisBlock = new Block(0, System.currentTimeMillis(), "Genesis Block", "0");
        genesisBlock.mineBlock(difficulty);
        blocks.add(genesisBlock);
    }

    public void addBlock(Block newBlock) {
        newBlock.setPreviousHash(getLatestBlock().getHash());
        newBlock.mineBlock(difficulty);
        blocks.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < blocks.size(); i++) {
            Block currentBlock = blocks.get(i);
            Block previousBlock = blocks.get(i - 1);
           
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Hash do bloco atual inválido.");
                return false;
            }
            
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Hash anterior do bloco atual não corresponde ao hash do bloco anterior.");
                return false;
            }
        }
        return true;
    }

    public Block getLatestBlock() {
        return blocks.get(blocks.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block block : blocks) {
            sb.append(block).append("\n");
        }
        return sb.toString();
    }
}
