package school.faang.doublecache;

public class Student {
    private static int ID_COUNTER = 0;
    private final int id;
    private final String name;

    public Student(String name) {
        ID_COUNTER++;
        this.id = ID_COUNTER;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
