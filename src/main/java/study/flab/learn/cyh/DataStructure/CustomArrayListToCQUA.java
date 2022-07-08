package study.flab.learn.cyh.DataStructure;

import java.util.Arrays;
import java.util.Objects;


class CustomArrayListToCQUA<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    protected int lastIndex;
    private int head;
    private int tail;

    protected CustomArrayListToCQUA() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    protected CustomArrayListToCQUA(int capacity) {
        //음수인 경우 에러처리
        if(capacity < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (capacity > 0) {
            this.elements = new Object[capacity];
            return;
        }
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    //O(1)
    protected int size() {
        return lastIndex;
    }

    //O(1)
    protected boolean isEmpty() {
        return lastIndex == 0;
    }

    //O(n)
    protected int indexOf(Object element) {
        for (int i = 0; i < lastIndex; i++) {
            if (Objects.equals(this.elements[i], element)) {
                return i;
            }
        }
        return -1;
    }

    //O(n)
    private E[] incDoublyCapacity() {
        int capacity = this.elements.length;
        Object[] elementsTemp = new Object[capacity * 2];
        for (int i = 0; i < lastIndex; i++) {
            elementsTemp[i] = elements[i];
        }
        return (E[]) elementsTemp;
    }

    //amortised O(1)
    protected boolean add(E element) {
        if (this.elements.length <= lastIndex) {
            this.elements = incDoublyCapacity();
        }
        this.elements[lastIndex++] = element;
        this.tail = lastIndex - 1;
        return true;
    }

    //O(n)
    protected void add(int index, E element) {
        //음수인 경우 에러처리
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (this.elements.length <= lastIndex) {
            this.elements = incDoublyCapacity();
        }

        for (int i = lastIndex; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        lastIndex++;
        this.tail = lastIndex- 1;
    }

    //O(1)
    protected E get(int index) {
        return (E) this.elements[index];
    }

    //O(1)
    protected E set(int index, E e) {
        return (E) (this.elements[index]=e);
    }

    //O(n)
    protected E remove(int index) {
        if (index == 0) {
            return removeFirst();
        }
        if (index == lastIndex) {
            return removeLast();
        }
        for (int i = index; i < lastIndex - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[--lastIndex] = null;
        return (E) this.elements;
    }

    protected E removeLast() {
        Object strRtn;
        strRtn = elements[tail];
        tail = tail - 1;
        lastIndex--;
        return (E) strRtn;
    }

    protected E removeFirst() {
        Object strRtn;
        if (lastIndex == 0) {
            return null;
        }
        if (lastIndex == 1) {
            strRtn = elements[head];
            head = 0;
            tail = 0;
            lastIndex--;
            return (E) strRtn;
        }
        strRtn = elements[head];
        head = head + 1;
        lastIndex--;
        return (E) strRtn;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = head; i < tail + 1; i++) {
            if (Objects.nonNull(elements[i])) {
                sb.append(elements[i].toString());
                if (i == tail) {
                    break;
                }
                sb.append(",");
            }
        }
//        return Arrays.toString(this.elements);
        return String.valueOf(sb);
    }
}