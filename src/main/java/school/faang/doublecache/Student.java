package school.faang.doublecache;

public class Student {
    private static int idCounter = 0;
    private int id;
    private String name;

    public Student(String name) {
        idCounter++;
        this.id = idCounter;
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
