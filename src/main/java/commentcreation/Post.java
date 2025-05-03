package commentcreation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments = new ArrayList<>();
}
