package Estructuras;

public class StackList {
    private DoubleList data;

    public StackList() {
        data = new DoubleList();
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

    public DoubleList getData() {
        return data;
    }

    public void setData(DoubleList data) {
        this.data = data;
    }
}
