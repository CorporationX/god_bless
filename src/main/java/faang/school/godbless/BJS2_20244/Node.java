package faang.school.godbless.BJS2_20244;

public class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T value) {
        this.value = value;
    }
}
