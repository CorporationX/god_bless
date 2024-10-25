package school.faang.writing_comment_BJS2_39160;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;
}