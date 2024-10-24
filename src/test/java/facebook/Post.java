package facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments;
    private final Lock lock = new ReentrantLock();

    public Post(int id, String title, String contentent, String author) {
        this.id = id;
        this.title = title;
        this.content = contentent;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public void addComment(Comment comment) {
        lock.lock();
        try {
            comments.add(comment);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", comments=" + comments +
                '}';
    }
}
