/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasSimples;

/**
 *
 * @author JEFERSON
 */
public class List {
    private Node head,tail;
    private int size;
    
    public void List(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void setSize(int s){
        this.size = s;
    }
    
    public Node first(){
        return head;
    }
    
    public Node last(){
        return tail;
    }
    
    public void addFirst(Object e){
        Node n = new Node(e);
        if (isEmpty()){
            head = n;
            tail = n;
        }else{
            n.setNext(head);
            head = n;
        }
        size++;
    }
    
    public void addLast(Object e){
        Node n = new Node(e);
        if(isEmpty()){
        head = n;
        tail = n;
        }else{
            tail.setNext(n);
            tail = n;     
        }
        size++;
    }
    
    public Object removeFirst(){
        if (isEmpty()){
            return null;
        }else{
            Node temp = head;
            head = temp.getNext();
            temp.setNext(null);
            size--;
            return temp.getData();
        }
    }
    
    public Object removeLast(){
        if(size == 1){
            return removeFirst();
        }else{
            Node temp = tail;
            Node anterior  = head;
            while(anterior.getNext()!= tail){
                anterior = anterior.getNext();
            }
            anterior.setNext(null);
            tail = anterior;
            size--;
            return temp.getData();
        }           
    }

}
