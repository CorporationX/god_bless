package derschrank.sprint01.task09.bjstwo_45093;


public record Product(int id, String name, String category) {
    @Override
    public String toString() {
        return String.format("[%s] Art. %d: %s", category, id, name);
    }
}
