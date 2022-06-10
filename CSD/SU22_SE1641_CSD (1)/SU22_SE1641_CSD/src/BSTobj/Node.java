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
public class Node {
    Person info;
    Node left , right;

    public Node( String name , int age) {
        info = new Person(name, age);
        left = right = null;
    }
    
    
}
