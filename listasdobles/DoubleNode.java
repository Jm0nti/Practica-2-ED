/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package jeferson.listasdobles;

/**
 *
 * @author JEFERSON
 */
public class DoubleNode {
    private Object data;
    private DoubleNode next,prev; 
    
    public DoubleNode(){
        this.data = null;
        this.next = null;
        this.prev = null;
    }
    public DoubleNode(Object d){
        this.data = d;
        this.next = null;
        this.prev = null;
    }

    public Object getData() {
        return data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setData(Object d) {
        this.data = d;
    }

    public void setNext(DoubleNode n) {
        this.next = n;
    }

    public void setPrev(DoubleNode p) {
        this.prev = p;
    }
    
}
