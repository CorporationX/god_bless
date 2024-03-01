package faang.school.godbless.commenting3243;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Post {
    private String header;
    private String text;
    private String author;
    private List<Comment> comments;

    public Post(String header, String text, String author) {
        this.header = header;
        this.text = text;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("""
                        %s
                        %s
                        %s
                        %s
                        """,
                this.getAuthor(),
                this.getHeader(),
                this.getText(),
                this.getComments());
    }
}
