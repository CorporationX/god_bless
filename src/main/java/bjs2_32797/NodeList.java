package bjs2_32797;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class NodeList<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public NodeList() {
        this.size = 0;
    }

    public void add(Node<T> node) {
        if (size == 0) {
            first = node;
            last = node;
        } else if (size == 1) {
            last = node;
            first.setNext(last);
            last.setPrevious(first);
        } else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
        size++;
    }

    public Node<T> removeFirst() {
        Node<T> node = first;
        first = first.getNext();
        first.setPrevious(null);
        size--;

        return node;
    }

    public Node<T> removeLast() {
        Node<T> node = last;
        last = last.getPrevious();
        last.setNext(null);
        size--;

        return node;
    }

    public void remove(Node<T> node) {
        if (node.equals(first)) {
            removeFirst();
        } else if (node.equals(last)) {
            removeLast();
        } else {
            Node<T> prevNode = node.getPrevious();
            Node<T> nextNode = node.getNext();

            prevNode.setNext(nextNode);
            nextNode.setPrevious(prevNode);
            size--;
        }
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node<T> current = first;

        while (current.hasNext() || current == last) {
            list.add(current.getValue());
            if (current == last) {
                break;
            }
            current = current.getNext();
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = first;

        while (current.hasNext() || current == last) {
            sb.append(current);
            sb.append('\n');

            if (current == last) {
                break;
            }
            current = current.getNext();
        }

        return sb.toString();
    }
}
