package faang.school.godbless.kxnvg.facebookcoments;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {

    private String header;
    private String postText;
    private User postAuthor;
    List<Comment> comments;

    public Post(String header, String postText, User postAuthor) {
        this.header = header;
        this.postText = postText;
        this.postAuthor = postAuthor;
        comments = new ArrayList<>();
    }
}
