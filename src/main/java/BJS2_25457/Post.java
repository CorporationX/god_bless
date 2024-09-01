package BJS2_25457;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private final int id;
    private String title;
    private String text;
    private final String author;
    private final List<Comment> comments = new ArrayList<>();
}
