public class Node {
    int info;
    Node left, right, parent;
    char color;

    public Node(int info, Node left, Node right, Node parent, char color) {
        this.info = info;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.color = color;
    }

    public Node(int info, char color) {
        this.info = info;
        this.color = color;
        left = right = parent = null;
    }

    public Node(int info) {
        this.info = info;
        left = right = parent = null;
        color = 'r';
    }

    @Override
    public String toString() {
        return info + (color == 'r' ? ", red" : ", black");
    }
}
