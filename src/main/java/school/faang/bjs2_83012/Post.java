package school.faang.bjs2_83012;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Post {
    private final long id;
    private String title;
    private String content;
    private User author;
    private List<Comment> comments;
}
