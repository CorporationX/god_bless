package faang.school.godbless.bjs2_25421;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
public class Post {
    private final int id;
    private final String header;
    private final String text;
    private final String author;
    private final List<Comment> comments = new ArrayList<>();
    private final Lock commentLock = new ReentrantLock();

    public Post(int id, String header, String text, String author) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.author = author;
    }

    public void addComment(Comment comment) {
        commentLock.lock();
        try {
            comments.add(comment);
            log.info("Comment '{}' was added to Post {}", comment.getText(), id);
        } finally {
            commentLock.unlock();
        }
    }

    public void deleteComment(int commentId, String author) {
        commentLock.lock();
        try {
            boolean success = comments.removeIf(c -> c.getId() == commentId && c.getAuthor().equals(author));
            if (success) {
                log.info("Comment '{}' was deleted from Post {} by {}", commentId, id, author);
            } else {
                log.info("{} have no access to delete Comment {}", author, commentId);
            }
        } finally {
            commentLock.unlock();
        }
    }
}
