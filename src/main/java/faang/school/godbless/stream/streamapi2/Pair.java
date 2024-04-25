package faang.school.godbless.stream.streamapi2;

public record Pair(int first, int second) {

    public Pair(int first, int second) {
        this.first = Math.min(first, second);
        this.second = Math.max(first, second);
    }
}
