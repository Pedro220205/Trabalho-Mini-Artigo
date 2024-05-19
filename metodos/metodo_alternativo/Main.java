package metodo_alternativo;

public class Main {
    public static void main(String[] args) {
        CloudBlockchainManager cbcManager = new CloudBlockchainManager();
        CloudComputeNode cloudNode1 = new CloudComputeNode();
        cbcManager.addNode(cloudNode1);

        CoreFogBlockchainManager cfbcmManager = new CoreFogBlockchainManager();
        LocalBlockchainManager localManager = new LocalBlockchainManager();
        FogBlockchainManager fogManager = new FogBlockchainManager();

        FogEdgeNode fogNode1 = new FogEdgeNode();
        FogEdgeNode fogNode2 = new FogEdgeNode();

        cfbcmManager.addNode(fogNode1);
        localManager.addNode(fogNode2);
        fogManager.addNode(fogNode1);
        fogManager.addNode(fogNode2);
    }
}
