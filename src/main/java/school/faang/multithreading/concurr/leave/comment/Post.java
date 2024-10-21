package school.faang.multithreading.concurr.leave.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Post {
    private final int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;
}
