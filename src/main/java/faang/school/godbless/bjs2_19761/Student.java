package faang.school.godbless.bjs2_19761;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Student extends AuditableEntity {
    private String name;
    private static int sequenceId;

    public Student(String name) {
        this.name = name;
        this.id = getNextSequenceId();
    }

    private int getNextSequenceId() {
        return ++sequenceId;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + "'}";
    }
}
