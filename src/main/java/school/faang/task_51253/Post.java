package school.faang.task_51253;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private int id;
    private String title = "Пост";
    private String content = "изучение рыбалки в диких условиях";
    private String author = "Рыбак";
    private List<Comment> comments = new ArrayList<>();

    public Post(int id) {
        this.id = id;
    }
}
