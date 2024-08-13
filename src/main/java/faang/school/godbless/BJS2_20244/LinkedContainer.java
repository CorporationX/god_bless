package faang.school.godbless.BJS2_20244;

import java.util.NoSuchElementException;

public class LinkedContainer<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedContainer() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(T value) {
        Node<T> temp = new Node<>(value);
        if (isEmpty()) {
            head = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
    }

    public void remove(Node<T> node) {
        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
        }
    }

    public Node<T> getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
