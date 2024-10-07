package school.faang.doublecache;

public record Student(int id, String name) {
    @Override
    public String toString() {
        return name;
    }
}
