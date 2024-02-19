package faang.school.godbless.r_edzie.hashmaps.double_cache;

import lombok.Data;

@Data
public class Grade {
    private Student student;
    private Subject subject;
    private int mark;

    public Grade(Student student, Subject subject, int mark) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
    }
}
