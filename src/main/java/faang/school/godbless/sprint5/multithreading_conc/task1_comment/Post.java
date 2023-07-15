package faang.school.godbless.sprint5.multithreading_conc.task1_comment;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Post {

    private int id;

    private String header;

    private String text;

    private String author;

    private List<Comment> comments;

    public Post(int id, String header, String text, String author) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.author = author;
        comments = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "id=" + id +
                        ", header='" + header + '\'' +
                        ", text='" + text + '\'' +
                        ", author='" + author + '\'';
    }
}
