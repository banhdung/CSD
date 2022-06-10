/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

/**
 *
 * @author admin
 */
public class BSTree {
    public static void main(String[] args) {
        int[] a = {50, 90, 70, 100, 30, 15, 10, 40, 45};
        /*
                        50
                  30          90
                15  40      70  100
              10      45
        */
        MyTree t = new MyTree();
        System.out.println("isEmpty?" + t.isEmpty());
        for (int i = 0; i < a.length; i++) {
            t.insert(a[i]);
        }
       // t.preOrder();
        t.breadth();
        t.dele(40);
        t.breadth();
       // System.out.println("Min:" + t.min());
    }
}
