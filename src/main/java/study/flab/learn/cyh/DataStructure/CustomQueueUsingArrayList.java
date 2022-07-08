package study.flab.learn.cyh.DataStructure;

public class CustomQueueUsingArrayList<E> {

//    public CustomArrayListToCSUA<E> arrayQueue = new CustomArrayListToCSUA<>();
    public CustomArrayListToCQUA<E> arrayQueue = new CustomArrayListToCQUA<>();

    //O(1)
    public boolean isEmpty() {
        return arrayQueue.size() == 0;
    }
    //O(1)
    public void enqueue(E e) {
        arrayQueue.add(e);
    }
    //O(1)
    public E dequeue() {
        return arrayQueue.remove(0);
    }
    //O(1)
    public E peek() {
        return arrayQueue.get(0);
    }

    @Override
    public String toString() {
        return "[" + arrayQueue + "]";
    }
}
