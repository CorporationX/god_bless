package faang.school.godbless.LeaveComment;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostService {
    @Getter
    private List<Post> posts = new ArrayList<>();

    public synchronized void addCommentToPostById(int id, Comment comment) {
        if (posts.get(id) != null) {
            posts.get(id).addComment(comment);
        }
    }

    public synchronized void addPost(Post post) {
        posts.add(post);
    }

    public void printAllPosts() {
        posts.forEach((k) -> System.out.println(k.getAuthor()));
    }

    public void printAllCommentsByPostId(int id) {
        posts.get(id).getComments().forEach(c -> System.out.println(c.getCommentText()));
    }
}
