package school.faang.leavingComments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments;

    public String formatPost() {
        return "Title: " + title + ". Content: " + content + ". Author: " + author + ". Comments:";
    }

    public static List<Post> generatePosts() {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Post post = new Post(i, "Title " + i, "Content " + i, "Author " + i, Comment.generateComments());
            posts.add(post);
        }
        return posts;
    }
}
