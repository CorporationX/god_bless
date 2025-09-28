package school.faang.bjs2_93612;

import lombok.Getter;

import java.util.List;

@Getter
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;
}