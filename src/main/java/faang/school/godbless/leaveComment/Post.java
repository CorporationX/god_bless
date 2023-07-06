package faang.school.godbless.leaveComment;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
public class Post {
    private String title;
    private String text;
    private String author;
    private List<Comment> comments = new ArrayList<>();
    private final ReentrantLock lockPost = new ReentrantLock();

    public Post(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
