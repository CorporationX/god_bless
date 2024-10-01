package faang.school.godbless.leave_comment;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String text;
    private List<Comment> comments;
    private String author;
}
