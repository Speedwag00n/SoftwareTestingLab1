package second;

public class SplayTreeNode {

    SplayTreeNode left, right, parent;
    int value;

    public SplayTreeNode() {
        this(0, null, null, null);
    }

    public SplayTreeNode(int value){
        this(value, null, null, null);
    }

    public SplayTreeNode(int value, SplayTreeNode left, SplayTreeNode right, SplayTreeNode parent){
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
