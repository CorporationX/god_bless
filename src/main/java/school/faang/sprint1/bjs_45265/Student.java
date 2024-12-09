package school.faang.sprint1.bjs_45265;

import lombok.Getter;

public class Student {
    private final int studentId;
    @Getter
    private final String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
}
