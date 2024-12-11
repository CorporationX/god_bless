package school.faang.doublecache;


public class Subject {
    private static int ID_COUNTER = 0;
    private final int id;
    private final String name;

    public Subject(String name) {
        ID_COUNTER++;
        this.id = ID_COUNTER;
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
