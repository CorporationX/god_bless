package school.faang.doublecache;

public class Student {
    private static int idCounter = 0;
    private final int studentId;
    private final String studentName;

    public Student(String name) {
        idCounter++;
        this.studentId = idCounter;
        this.studentName = name;
    }

    @Override
    public String toString() {
        return "Student{"
                + "id=" + studentId
                + ", name='" + studentName + '\''
                + '}';
    }
}
