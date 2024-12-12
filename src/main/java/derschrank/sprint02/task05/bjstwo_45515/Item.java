package derschrank.sprint02.task05.bjstwo_45515;

public record Item(String name, int value) {
    @Override
    public String toString() {
        return name + ":  " + value + "$";
    }
}
