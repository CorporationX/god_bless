package school.faang.leaving_comments;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@ToString
@RequiredArgsConstructor
public class PostService {
    private final List<Post> posts = new CopyOnWriteArrayList<>();
    private final Object postLock = new Object();
    private final Object commentLock = new Object();


    public void addPost(Post post) {
        posts.add(post);
        log.info("Post added: {}", post);
    }

    public void deletePost(int postId, String user) {
        synchronized (postLock) {
            posts.removeIf(post -> {
                if (post.getId() == postId && post.getAuthor().equals(user)) {
                    synchronized (commentLock) {
                        post.getComments().clear();
                    }
                    return true;
                }
                return false;
            });
        }
    }

    public void addComment(int postId, Comment comment) {
        synchronized (postLock) {
            Post post = getPostById(postId).orElseThrow(() ->
                    new NoSuchElementException("Post not found with ID: " + postId));
            synchronized (commentLock) {
                post.getComments().add(comment);
            }
        }
    }


    public void deleteComment(int postId, int commentId, String user) {
        synchronized (postLock) {
            Post post = getPostById(postId)
                    .orElseThrow(() -> new NoSuchElementException("Post not found with ID: " + postId));
            synchronized (commentLock) {
                post.getComments().removeIf(comment ->
                        comment.getId() == commentId && comment.getAuthor().equals(user));
            }
        }
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public List<Comment> getCommentsByPostId(int postId) {
        synchronized (postLock) {
            Post post = getPostById(postId)
                    .orElseThrow(() -> new NoSuchElementException("Post not found with ID: " + postId));
            return List.copyOf(post.getComments());
        }
    }

    public Optional<Post> getPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst();
    }
}
