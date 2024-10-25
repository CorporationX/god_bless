package school.faang.task421.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import school.faang.task421.comment.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private final List<Comment> comments = new ArrayList<>();

}
