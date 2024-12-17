package school.faang.doublecache;


public class Subject {
    private static int idCounter = 0;
    private final int subjectId;
    private final String subjectName;

    public Subject(String name) {
        idCounter++;
        this.subjectId = idCounter;
        this.subjectName = name;
    }

    @Override
    public String toString() {
        return "Subject{"
                + "id=" + subjectId
                + ", name='" + subjectName + '\''
                + '}';
    }
}
