package school.faang.doublecache;

public record Subject(int id, String name) {
    @Override
    public String toString() {
        return name;
    }
}
