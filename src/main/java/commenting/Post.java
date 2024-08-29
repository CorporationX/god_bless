package commenting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private String header;
    private String text;
    private final String author;
    private final List<Comment> comments = new ArrayList<>();
}
