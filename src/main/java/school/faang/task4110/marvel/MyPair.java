package school.faang.task4110.marvel;

public class MyPair<T> {
    private T first;
    private T second;

    public MyPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
