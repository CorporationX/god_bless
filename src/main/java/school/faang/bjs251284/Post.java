package school.faang.bjs251284;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class Post {

    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments;

    public Post(int id, String title, String content, String author) {
        if (title == null || title.isEmpty()) {
            log.error("Title cannot be null or empty");
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (content == null || content.isEmpty()) {
            log.error("Content cannot be null or empty");
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
        if (author == null || author.isEmpty()) {
            log.error("Author cannot be null or empty");
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
        log.info("Post created by {} with title {}", author, title);
    }

    public void addComment(Comment coment) {
        comments.add(coment);
    }
}
