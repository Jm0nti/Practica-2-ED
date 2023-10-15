package Estructuras;

public class QueueList{
    private List data;

    public QueueList() {
        data = new List();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(Object e) {
        data.addLast(e);
    }

    public Object dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return data.removeFirst();
        }
    }

    public Object first() {
        if (isEmpty()) {
            return null;
        } else {
            return data.first().getData();
        }
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
