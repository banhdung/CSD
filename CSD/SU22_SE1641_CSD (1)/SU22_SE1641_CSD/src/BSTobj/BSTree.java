/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTobj;

import java.io.IOException;

/**
 *
 * @author banhdung
 */
public class BSTree {
    public static void main(String[] args) throws IOException {
        MyTree t = new MyTree();
        t.insert("Quang", 10);
        t.insert("Huy", 20);
        t.insert("Duc Anh", 30);
        t.insert("Yen", 40);
        t.insert("Tu", 50);
        t.insert("Ba", 60);
     
        
        
        System.out.println(t.getInfo());
     

    }
}
