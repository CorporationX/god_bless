package school.faang.sprint1.bjs_45265;

import lombok.Getter;

import java.util.Objects;

public class Student {
    private final int studentId;
    @Getter
    private final String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student student)) {
            return false;
        }
        return studentId == student.studentId && Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName);
    }

    @Override
    public String toString() {
        return " " + studentName + ",";
    }
}
