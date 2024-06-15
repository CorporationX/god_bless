package faang.school.godbless.stream_split.stream_api_2;


public record Pair<T extends Comparable<T>>(T first, T second) {

    public Pair<T> sort() {
        if (first.compareTo(second)<0) {
            return new Pair<>(second, first);
        } else {
            return this;
        }
    }
}
