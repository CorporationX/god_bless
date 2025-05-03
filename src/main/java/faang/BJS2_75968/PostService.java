package faang.BJS2_75968;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PostService {
    private final List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public synchronized void addComment(int postId, Comment comment) {
        Post post = findPostById(postId);
        if (post != null) {
            post.add(comment);
        }
    }

    public synchronized void deletePost(int postId, String person) {
        Post post = findPostById(postId);
        if (post != null && post.getAuthor().equals(person)) {
            posts.remove(post);
        }
    }

    public synchronized void deleteComment(int postId, Comment comment, String commentAuthor) {
        Post post = findPostById(postId);
        if (post != null && comment.author().equals(commentAuthor)) {
            post.deleteComment(comment);
        }
    }

    private Post findPostById(int postId) {
        synchronized (posts) {
            return posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst()
                    .orElse(null);
        }
    }

    public synchronized List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public synchronized List<Comment> getComments(int postId) {
        Post post = findPostById(postId);
        return post != null ? post.getComments() : Collections.emptyList();
    }
}
