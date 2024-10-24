package bjs2_37887;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Post {
    private final int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;
}
