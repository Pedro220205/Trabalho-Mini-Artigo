package metodo_alternativo;

import java.util.ArrayList;
import java.util.List;

public class FogBlockchainManager {
    private List<FogEdgeNode> nodes;

    public FogBlockchainManager() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(FogEdgeNode node) {
        nodes.add(node);
    }

    public void removeNode(FogEdgeNode node) {
        nodes.remove(node);
    }
}
