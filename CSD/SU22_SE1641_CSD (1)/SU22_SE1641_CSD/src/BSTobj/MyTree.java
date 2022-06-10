/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTobj;

/**
 *
 * @author banhdung
 */
public class MyTree {
    Node root ;

    public MyTree() {
        root = null;
    }
    
    boolean isEmpty() {
        return root == null;
    }
    void clear() {
        root = null;
    }
    
    void insert(String name , int age) {
        if (isEmpty()) {
            root = new BSTobj.Node(name, age);
            return;
        }
        if(name.startsWith("B"))
            return ;
        BSTobj.Node p = root;
        BSTobj.Node parent = null; // parent la cha p
        while (p != null) {
            parent = p;
            if (p.info.name.compareTo(name)==0) {
                return;
            }
            else if (p.info.name.compareTo(name) > 0 ) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (parent.info.name.compareTo(name) > 0 ) {
            parent.left = new BSTobj.Node(name , age);
        } else {
            parent.right = new BSTobj.Node(name , age);
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
        System.out.print(p.info.name + " " + p.info.age+" ");
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

}
    
      

 