package school.faang.task_51141;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments = new ArrayList<>();
}
