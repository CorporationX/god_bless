package sprint5.comment;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    public synchronized void addComment(int postId, Comment comment) {
        if (postId >= posts.size()) {
            throw new IllegalArgumentException("There is no such post");
        }
        posts.get(postId)
                .getComments().add(comment);
    }

    public synchronized void deleteComment(int postId, String author) {
        if (postId >= posts.size()) {
            throw new IllegalArgumentException("There is no such post");
        }
        List<Comment> comments = posts.get(postId).getComments();
        Optional<Comment> optionalComment = comments.stream()
                .filter(comment -> comment.author().equals(author))
                .findFirst();
        optionalComment.ifPresent(comments::remove);
    }

    public synchronized List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public synchronized void addPost(Post post) {
        posts.add(post);
    }

    public synchronized void deletePost(Post post) {
        if (!posts.contains(post)) {
            throw new IllegalArgumentException("There is no such post");
        }
        posts.remove(post);
    }
}
