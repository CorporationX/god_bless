package derschrank.task10.bjstwo_45209;

public record Subject(int id, String name) {

    @Override
    public String toString() {
        return name;
    }
}
