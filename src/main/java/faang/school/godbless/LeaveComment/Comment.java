package faang.school.godbless.LeaveComment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Comment {
    private String author;
    private String comment;
    private String dateTime;

    @Override
    public String toString() {
        return "Comment{" +
                "author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
