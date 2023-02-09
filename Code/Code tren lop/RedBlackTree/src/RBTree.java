import java.util.LinkedList;
import java.util.Queue;

public class RBTree {
    Node root;

    public RBTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void inOrder(Node v) {
        if (v != null) {
            inOrder(v.left);
            System.out.println(v);
            inOrder(v.right);
        }
    }

    public void preOrder(Node v) {
        if (v != null) {
            System.out.println(v);
            preOrder(v.left);
            preOrder(v.right);
        }
    }

    public void postOrder(Node v) {
        if (v != null) {
            postOrder(v.left);
            postOrder(v.right);
            System.out.println(v);
        }
    }

    public void breadth(Node v) {
        if (v != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(v);
            Node q = null;
            while (!queue.isEmpty()) {
                q = queue.remove();
                System.out.println(q);
                if (q.left != null)
                    queue.add(q.left);
                if (q.right != null)
                    queue.add(q.right);
            }
        }
    }

    public Node search(int x, Node v) {
        if (v == null) {
            return null;
        } else{
            if(x==v.info){
                return v;
            }
            else if(x<v.info){
                return search(x,v.left);
            }
            else{
                return search(x,v.right);
            }

        }
    }

    public Node search(int x){
        return search(x,root);
    }

    public Node findMaxNode(Node v) {
        if (v == null) {
            return null;
        } else {
            Node p = v;
            while(p.right!=null){
                p=p.right;
            }
            return p;
        }
    }

    public Node findMinNode(Node v) {
        if (v == null) {
            return null;
        } else {
            Node p = v;
            while(p.left!=null){
                p=p.left;
            }
            return p;
        }
    }


}