package faang.school.godbless.bjs2_19761;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Subject extends AuditableEntity {
    private String name;
    private static int sequenceId;

    public Subject(String name) {
        this.name = name;
        this.id = getNextSequenceId();
    }

    private int getNextSequenceId() {
        return ++sequenceId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name='" + name + "'}";
    }
}
