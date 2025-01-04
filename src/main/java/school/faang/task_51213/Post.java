package school.faang.task_51213;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Getter
@ToString
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;

    public Post(long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment newComment) {
        this.comments.add(newComment);
    }

    public void deleteComment(Comment commentForDelete) {
        if (this.comments.removeIf(comment -> Objects.equals(comment.author(), commentForDelete.author())
                && Objects.equals(comment.timestamp(), commentForDelete.timestamp()))) {
            log.info("Комментарий {} удален", commentForDelete.id());
        }
    }
}
