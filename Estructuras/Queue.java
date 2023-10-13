package Estructuras;

public class Queue<T> {
    private List data;

    public Queue() {
        data = new List();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(T e) {
        data.addLast(e);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) data.removeFirst();
        }
    }

    public T first() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) data.first().getData();
        }
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
