package school.faang.sprint.fourth.facebookcomments;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
    private final int id;
    @NonNull
    private final String title;
    @NonNull
    private final String content;
    @NonNull
    private final String author;
    @NonNull
    private final List<Comment> comments;

    public Post(int id, @NonNull String title, @NonNull String content, @NonNull String author) {
        validate(id, title, content, author);
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }


    private void validate(int id, String title, String content, String author) {
        if (id < 0) {
            throw new IllegalArgumentException("Post id cannot be negative");
        }
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        if (content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be blank");
        }
        if (author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be blank");
        }
    }
}
