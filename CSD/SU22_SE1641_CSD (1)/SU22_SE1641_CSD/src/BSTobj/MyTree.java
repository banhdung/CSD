/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTobj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author banhdung
 */
public class MyTree {

    Node root;

    public MyTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void clear() {
        root = null;
    }

    void insert(String name, int age) {
        if (isEmpty()) {
            root = new BSTobj.Node(name, age);
            return;
        }
        if (name.startsWith("B")) {
            return;
        }
        BSTobj.Node p = root;
        BSTobj.Node parent = null; // parent la cha p
        while (p != null) {
            parent = p;
            if (p.info.name.compareTo(name) == 0) {
                return;
            } else if (p.info.name.compareTo(name) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (parent.info.name.compareTo(name) > 0) {
            parent.left = new BSTobj.Node(name, age);
        } else {
            parent.right = new BSTobj.Node(name, age);
        }
    }

    void breadth() {
        BSTobj.MyQueue q = new BSTobj.MyQueue();
        q.enqueue(root);
        BSTobj.Node p;
        while (!q.isEmpty()) {
            p = (BSTobj.Node) q.dequeue();
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

    void visit(Node p) {
        System.out.print(p.info.name + " " + p.info.age + " ");
    }
    //. Calculate the height of the tree

    int height(BSTobj.Node p) {
        if (p == null) {
            return 0;
        }
        int hLeft = height(p.left);
        int hRight = height(p.right);
        int max = hLeft >= hRight ? hLeft : hRight;
        return max + 1;
    }

    //Calculate the number of nodes of the tree.
    int count(BSTobj.Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + count(p.left) + count(p.right);
    }

    int count() {
        return count(root);
    }

    public int sumAge(Node p) {
        if (p == null) {
            return 0;
        }
        int sum = 0;
        sum += p.info.getAge();
        return sum += sumAge(p.left) + sumAge(p.right);
    }

    public double ageAverage() {
        return sumAge(root) / count();     // return average age
    }
    String result = "";

    public String getInfo(Node p) throws IOException {

        if (p == null) {
            return "";
        }
        
        getInfo(p.left);
        getInfo(p.right);
        if (p.info.getAge() < ageAverage()) {
            result += p.info.toString() + " ";
        }
        
        return result;
    }

    public String getInfo() throws IOException {
        return getInfo(root);
    }

    public void writeFile() throws IOException {
        File source = new File("q2.txt");
        FileWriter out = new FileWriter(source);
        out.write(getInfo(root));
        out.close();
    }

    // delete by name
    public void delete(String name) {
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.getName().equalsIgnoreCase(name)) {
                break;
            }
            parent = p;
            if (p.info.getName().compareTo(name) > 0) { // A compare B return -1 
                p = p.left;
            } else {
                p = p.right;
            }

        }
        //p == null => không có x trong tree, hoặc p chứa x
        if (p == null) {
            return;
        }
        //---------Trường hợp 1: p không có con------------
        /*
                parent      parent           p
               p                   p
         */
        if (p.left == null && p.right == null) {
            if (parent == null) {
                root = null;
                return;
            }
            if (parent.left == p) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } //---------Trường hợp 1: p có 1 con------------
        /*
            parent      parent      parent        parent             p        p
           p           p                   p             p          L           R
          L              R               L                  R                                
         */ //p has left child only
        else if (p.left != null && p.right == null) {
            if (parent == null) {
                root = p.left;
            } else if (parent.left == p) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } //p has right child only
        else if (p.left == null && p.right != null) {
            if (parent == null) {
                root = p.right;
            } else if (parent.left == p) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        } //---------Trường hợp 1: p có 2 con------------
        /*
                p                   p
          p.L                     rm
          ...                   L
             parentRM
                      rm
                   L 
         */ else if (p.left != null && p.right != null) {

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

    Node parent(Node ch) {
        if (ch == root || ch == null) {
            return null;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.name.equals(ch.info.name)) {
                break;
            }
            parent = p;
            if (p.info.name.compareTo(ch.info.name) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return parent;
    }

    void rotateRight(Node par) {
        if (par == null || par.left == null) {
            return;
        }
        Node ch = par.left;
        par.left = ch.right;
        ch.right = par;
        if (parent(par) == null) {
            root = ch;
            return;
        }
        if (parent(par).left == par) {
            parent(par).left = ch;
        } else {
            parent(par).right = ch;
        }
    }

    void rotateLeft(Node par) {
        if (par == null || par.right == null) {
            return;
        }
        Node ch = par.right;
        par.right = ch.left;
        ch.left = par;
        if (parent(par) == null) {
            root = ch;
            return;
        }
        if (parent(par).left == par) {
            parent(par).left = ch;
        } else {
            parent(par).right = ch;
        }
    }

    public void printBF() {

        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue(); // p == root
            System.out.println(p.info.toString() + ": " + getBF(p) + "\t");
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
        System.out.println("");
    }

    public int getBF(Node p) {
        return height(p.right) - height(p.left);
    }

    //Balance Factor = height(left-child) - height(right-child).
    //delete by copying the second node having age >= the average age
    public void delte2ndNode() {
        int count = 0;
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.info.getAge() >= ageAverage()) {
                count += 1;
            }
            if (count == 2) {
                delete(p.info.getName());
                return;
            }
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
    }

    // rotate the third node having non-empty right-son
    int count = 0;

    public void rotateByPreO(Node p) {

        if (p == null) {
            return;
        }
        if (p.right != null) {
            count++;
        }
        if (count == 3) {
            rotateLeft(p);
            return;
        }
        rotateByPreO(p.left);
        rotateByPreO(p.right);
    }
    
    
}
