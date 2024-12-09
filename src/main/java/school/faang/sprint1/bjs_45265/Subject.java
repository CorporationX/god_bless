package school.faang.sprint1.bjs_45265;

import lombok.Getter;

public class Subject {
    private final int subjectId;
    @Getter
    private final String subjectName;

    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
}
