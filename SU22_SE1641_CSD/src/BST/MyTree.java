/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

/**
 *
 * @author
 */
public class MyTree {

    Node root;

    public MyTree() {
        root = null;
    }

    //1
    boolean isEmpty() {
        return root == null;
    }

    //2
    void clear() {
        root = null;
    }
    //3

    Node search(int x) {
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.info == x) {
                return p;
            }
            if (p.left != null) {
                q.enqueue(p.left);
            }

            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
        return null;
    }

    //4
    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node p = root;
        Node parent = null; // parent la cha p
        while (p != null) {
            parent = p;
            if (p.info == x) {
                return;
            }
            if (p.info > x) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (parent.info > x) {
            parent.left = new Node(x);
        } else {
            parent.right = new Node(x);
        }
    }

    //6
    void visit(Node p) {
        System.out.print(p.info + " ");
    } // p - l - r

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void preOrder() {
        preOrder(root);
        System.out.println("");
    }

    //7 l - p - r
    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        if (p.left != null) {
            inOrder(p.left);
        }
        visit(p);
        if (p.right != null) {
            inOrder(p.right);
        }

    }

    void inOrder() {
        inOrder(root);
        System.out.println("");
    }

    //8 l - r - p
    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        if (p.left != null) {
            postOrder(p.left);
        }
        if (p.right != null) {
            postOrder(p.right);
        }
        visit(p);
    }

    void postOrder() {
        postOrder(root);
        System.out.println("");
    }

    void breadth() {
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            visit(p);
            if (p.left != null) {
                q.enqueue(p.left);
            }

            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
        System.out.println("");
    }

    //9
    int count(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + count(p.left) + count(p.right);
    }

    int count() {
        return count(root);
    }

    //10
    void dele(int x) {
        // tim node chua x
        // phan loai truong hop xoa node chua x
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node parent = null;

        while (p != null) {
            if (p.info == x) {
                break;
            }
            parent = p;
            if (p.info > x) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        // p = null ( khong co x trong cay ) , hoac p chua x
        if (p == null) {
            return;
        }
        //TH1 : p khong co con
        if (p.left == null && p.right == null) {
            // p == root
            if (parent == null) {
                root = null;
                return;
            }
            if (parent.left == p) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        //TH2 : p co  1 con
        if ((p.left != null && p.right == null) && (p.left == null && p.right != null)) {
            //p la con trai(phai) co con trai , p la con trai(phai) co con phai , p la root
            if (parent == null) {
                root = null;
                return;
            }
            if (parent.left == p) {
                if (p.left != null && p.right == null) {
                    parent.left = p.left;
                } else if (p.left == null && p.right != null) {
                    parent.left = p.right;
                   
                }

            }
            if (parent.right == p) {
                if (p.left != null && p.right == null) {
                    parent.left = p.left;
                } else if (p.left == null && p.right != null) {
                    parent.left = p.right;
                }

            }
        }

        //TH3 : p co  2 con
        if (p.left != null && p.right != null) {
            // tim righmost cua p.L
            //copy gia tri cua rightmost vao p
            // xoa rightmost

            Node rm = p.left;
            Node parentRM = null;
            while (rm.right != null) {
                parentRM = rm;
                rm = rm.right;
            }
            p.info = rm.info;
            if (parentRM == null) {
                p.left = rm.left;
            } else {
                parentRM.right = rm.left;
            }
        }
    }

    //11
    int min() {
        if (isEmpty()) {
            return -1;
        }
        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.info;
    }

    //12
    int max() {
        if (isEmpty()) {
            return -1;
        }
        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p.info;
    }

    //13
    int sum(Node p) {
        if (p == null) {
            return 0;
        }
        return p.info + sum(p.left) + sum(p.right);
    }

    int sum() {
        return sum(root);
    }

    //14
    int avg() {
        return sum() / count();
    }

    int height(Node p) {
        if (p == null) {
            return 0;
        }
        int hLeft = height(p.left);
        int hRight = height(p.right);
        int max = hLeft >= hRight ? hLeft : hRight;
        return max + 1;
    }

}
