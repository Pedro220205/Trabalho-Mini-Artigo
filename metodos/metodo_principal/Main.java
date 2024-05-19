package metodo_principal;
import java.security.KeyPair;

public class Main {
    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain(3);

        KeyPair keyPair = Utils.generateKeyPair();

        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();

        String data = "Exemplo de dado para assinar";

        byte[] digitalSignature = Utils.generateDigitalSignature(keyPair.getPrivate(), data);

        boolean isSignatureValid = Utils.verifyDigitalSignature(keyPair.getPublic(), data, digitalSignature);

        System.out.println("Assinatura digital válida? " + isSignatureValid);

        System.out.println("Chave privada: " + privateKeyBytes);
        System.out.println("Chave pública: " + publicKeyBytes);

        System.out.println("\nBlockchain:");
        System.out.println(blockchain);

        blockchain.addBlock(new Block(blockchain.getLatestBlock().getIndex() + 1, System.currentTimeMillis(), "Novos dados", blockchain.getLatestBlock().getHash()));

        System.out.println("\nBlockchain após adicionar novo bloco:");
        System.out.println(blockchain);

        System.out.println("Blockchain válida? " + blockchain.isChainValid());
    }
}
