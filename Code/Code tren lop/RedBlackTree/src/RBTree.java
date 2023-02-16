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
        } else {
            if (x == v.info) {
                return v;
            } else if (x < v.info) {
                return search(x, v.left);
            } else {
                return search(x, v.right);
            }

        }
    }

    public Node search(int x) {
        return search(x, root);
    }

    public Node findMaxNode(Node v) {
        if (v == null) {
            return null;
        } else {
            Node p = v;
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
    }

    public Node findMinNode(Node v) {
        if (v == null) {
            return null;
        } else {
            Node p = v;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
    }

    public Node insert(int x) {
        if (root == null) {
            root = new Node(x, 'r');
            return root;
        } else {
            Node tmp = root;
            Node father = null;
            while (tmp != null) {
                if (tmp.info == x) {
                    return null;
                } else if (x < tmp.info) {
                    father = tmp;
                    tmp = tmp.left;
                } else {
                    father = tmp;
                    tmp = tmp.right;
                }
            }
            if (x < father.info) {
                father.left = new Node(x, 'r');
                return father.left;
            } else {
                father.right = new Node(x, 'r');
                return father.right;
            }
        }
    }

    public void rotateLeft(Node p) {
        if (p.right != null && p != null) {
            Node f = p.parent;
            Node r = p.right;
            r.left = p;
            p.right = r.left;
            r.left = p;
            if (p.right != null) {
                p.right.parent = p;
            }
            p.parent = r;
            if (f == null)
                root = r;
            else {
                r.parent = f;
                if (r.info < f.info)
                    f.left = r;
                else
                    f.right = r;
            }
        }
    }

    public void rotateRight(Node p) {
        if (p.left != null && p != null) {
            Node f = p.parent;
            Node l = p.left;
            p.left = l.right;
            l.right = p;
            if (p.left != null) {
                p.left.parent = p;
            }
            p.parent = l;
            // nut f la cha cua l
            if (f == null)
                root = l;
            else {
                l.parent = f;
                if (l.info < f.info)
                    f.left = l;
                else
                    f.right = l;
            }
        }
    }

    public Node findUncle(Node p) {
        if (p == null || p == root) {
            return null;
        } else {
            Node father = p.parent;
            if (father == root) {
                return null;
            } else {
                Node grandFather = father.parent;
                if (grandFather.left == father) {
                    return grandFather.right;
                } else {
                    return grandFather.left;
                }
            }
        }
    }

    public void fixColor(Node x) {
        if (x != null) {
            if (x == root) {
                x.color = 'b';
            } else {
                Node f = x.parent;
                if (f.color == 'r') {
                    Node gf = f.parent;
                    Node u = findUncle(x);
                    if (u != null && u.color == 'r') {
                        f.color = u.color = 'b';
                        gf.color = 'r';
                        fixColor(gf);
                    } else {
                        if (f.left == x && gf.left == f) {
                            rotateRight(gf);
                            f.color = 'b';
                            gf.color = 'r';
                        } else if (f.right == x && gf.right == f) {
                            rotateLeft(gf);
                            f.color = 'b';
                            gf.color = 'r';
                        } else if (f.right == x && gf.left == f) {
                            rotateLeft(f);
                            rotateRight(gf);
                            x.color = 'b';
                            gf.color = 'r';
                        } else if (f.left == x && gf.right == f) {
                            rotateRight(f);
                            rotateLeft(gf);
                            x.color = 'b';
                            gf.color = 'r';
                        }
                    }
                }

            }
        }
    }

    public void insertLRBTree(int x) {
        Node p = insert(x);
        fixColor(p);
    }

}