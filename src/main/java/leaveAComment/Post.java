package leaveAComment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private String header;
    private String text;
    private String author;
    private final List<Comment> comments = new ArrayList<>();
}
