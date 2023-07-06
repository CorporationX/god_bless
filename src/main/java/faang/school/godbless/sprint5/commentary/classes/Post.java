package faang.school.godbless.sprint5.commentary.classes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
    private String title;
    private String body;
    private String author;
    private List<Comment> comments;

    public Post() {
        this.comments = new ArrayList<>();
    }

}