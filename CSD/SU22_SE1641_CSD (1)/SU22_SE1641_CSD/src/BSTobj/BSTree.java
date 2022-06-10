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
public class BSTree {
    public static void main(String[] args) {
        MyTree t = new MyTree();
        t.insert("Quang", 0);
        t.insert("Huy", 0);
        t.insert("Duc Anh", 0);
        t.insert("Yen", 0);
        t.insert("Tu", 0);
        t.insert("Ba", 0);
        t.breadth();
        
        System.out.println(t.height(t.root));
    }
}
