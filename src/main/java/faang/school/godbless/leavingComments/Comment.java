package faang.school.godbless.leavingComments;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Comment {
    private int id;
    private String text;
    private String authorName;
    private LocalDate date;

    public Comment(int id, String text, String authorName) {
        this.id = id;
        this.text = text;
        this.authorName = authorName;
        this.date = LocalDate.now();
    }
}
