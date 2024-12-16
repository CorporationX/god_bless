package school.faang.doublecache;


public class Subject {
    private static int idCounter = 0;
    private int id;
    private String name;

    public Subject(String name) {
        idCounter++;
        this.id = idCounter;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
