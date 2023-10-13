package Estructuras;

public class Stack {
    private List data;

    public Stack() {
        data = new List();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(Object e) {
        data.addFirst(e);
    }

    public Object pop() {
        return data.removeFirst();
    }

    public Object top() {
        if (!isEmpty()) {
            return data.first().getData();
        } else {
            return null;
        }
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
