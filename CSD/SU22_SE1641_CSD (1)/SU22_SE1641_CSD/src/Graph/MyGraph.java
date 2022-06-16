/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author banhdung
 */
public class MyGraph {

    int n; // so luong dinh
    int[][] a; //ma tran lien ke
    char[] v; //ten cua dinh

    public MyGraph() {
        v = "ABCDEFGHIJKMN".toCharArray();

    }

    void setData(int[][] b) {
        n = b.length;
        a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = b[i][j];

            }
        }
    }

    void display() {
        for (int i = 0; i < n; i++) {
            System.out.println(v[i] + ": ");
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) {
                    System.out.print(v[j] + " ");
                }
            }
        }
    }

    void visit(int k) {
        System.out.println(v[k] + " ");
    }

    void breath(boolean[] enqueued, int k) {
        MyQueue q = new MyQueue();
        int i, h;
        q.enqueue(new Integer(k));
        enqueued[k] = true;
        while (!q.isEmpty()) {
            h = Integer.parseInt((q.dequeue()).toString().trim());
            visit(h);
            for (i = 0; i < n; i++) {
                if ((!enqueued[i]) && a[h][i] > 0) {
                    q.enqueue(new Integer(i));
                    enqueued[i] = true;
                }
            }
        }
    }

    void breadth(int k) {
        MyQueue q = new MyQueue();
        
        boolean[] enqueued = new boolean[n];
        for (int i = 0; i < n; i++) {
            enqueued[i] = false;
        }
        breath(enqueued, k);
        for (int i = 0; i < n; i++) {
            if(!enqueued[i]){
                breath(enqueued, i);
            }
        }
        System.out.println();
    }

}
