package school.BJS2_39188;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {

    private int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments = new ArrayList<>();

    public Post(int id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
