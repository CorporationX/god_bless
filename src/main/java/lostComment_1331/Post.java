package lostComment_1331;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Post {

    private String subject;
    private String text;
    private String author;
    private List<Comment> comments;
}
