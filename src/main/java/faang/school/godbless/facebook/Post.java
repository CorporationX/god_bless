package faang.school.godbless.facebook;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Post {
    @Getter
    private Long id;
    private String title;
    private String text;
    private String author;
    private ConcurrentHashMap<Long, Comment> commentById = new ConcurrentHashMap<>();

    public Post(Long id, String title, String text) {
        if (title == null) {
            throw new IllegalArgumentException("In constructor Post class apply String title is null");
        }
        if (text == null) {
            throw new IllegalArgumentException("In constructor Post class apply String text is null");
        }
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public void addComment(Comment comment) {
        commentById.put(comment.getId(), comment);
    }

    public Map<Long, Comment> getAllCommentForPost() {
        return new HashMap<>(commentById);
    }
}
