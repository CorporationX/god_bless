package school.faang.bjs2_83016;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private final List<Comment> comments = new ArrayList<>();
}
