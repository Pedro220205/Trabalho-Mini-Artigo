package metodo_alternativo;

import java.util.ArrayList;
import java.util.List;

public class CloudBlockchainManager {
    private List<CloudComputeNode> nodes;

    public CloudBlockchainManager() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(CloudComputeNode node) {
        nodes.add(node);
    }

    public void removeNode(CloudComputeNode node) {
        nodes.remove(node);
    }
}
