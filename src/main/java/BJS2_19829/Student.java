package BJS2_19829;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Student {
    private int studentId;
    private String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getStudentId() == student.getStudentId() && Objects.equals(getStudentName(), student.getStudentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getStudentName());
    }
}
