/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasSimples;

/**
 *
 * @author JEFERSON
 */
public class Node {
    private Object data;
    private Node next;
 
    public Node(){
        data = null;
        next = null;
    }
    public Node(Object e){
        this.data = e;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    
 
}
