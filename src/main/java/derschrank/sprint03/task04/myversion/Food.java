package derschrank.sprint03.task04.myversion;

public record Food(
        String name
) {
    @Override
    public String toString() {
        return name;
    }
}
