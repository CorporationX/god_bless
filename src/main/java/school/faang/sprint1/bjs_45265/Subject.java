package school.faang.sprint1.bjs_45265;

import lombok.Getter;

import java.util.Objects;

public class Subject {
    private final int subjectId;
    @Getter
    private final String subjectName;

    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return subjectId == subject.subjectId && Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, subjectName);
    }

    @Override
    public String toString() {
        return " " + subjectName + " ";
    }
}
