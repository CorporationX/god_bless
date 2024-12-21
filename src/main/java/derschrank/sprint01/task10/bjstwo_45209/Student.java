package derschrank.sprint01.task10.bjstwo_45209;

public record Student(int id, String name) {

    @Override
    public String toString() {
        return name;
    }
}
