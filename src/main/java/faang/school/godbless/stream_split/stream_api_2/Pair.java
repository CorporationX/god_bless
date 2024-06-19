package faang.school.godbless.stream_split.stream_api_2;

// я горжусь этим рекордом)
public record Pair<T extends Comparable<T>>(T first, T second) {

    public Pair<T> sort() {
        if (first.compareTo(second) < 0) {
            return new Pair<>(second, first);
        }
        return this;
    }
}