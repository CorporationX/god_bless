package school.faang.leavecomment;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class PostService {
    private final Map<Integer, Post> postsById = new ConcurrentHashMap<>();

    public void addPost(@NonNull Post post) {
        postsById.put(post.getId(), post);
        log.info("Added post (postId={})", post.getId());
    }

    public void addComment(int postId, Comment comment) {
        if (postId == 0 || comment == null) {
            log.error("Adding comment error (postId={} comment={})", postId, Objects.requireNonNull(comment));
            throw new IllegalArgumentException("Post id must not be 0 and comment must not be null!");
        }
        postsById.get(postId).addComment(comment);
        log.info("Added comment (commentId={}) to post (postId={})", comment.getId(), postId);
    }

    public List<Post> getAllPosts() {
        if (postsById.isEmpty()) {
            log.error("Trying get all posts, but postsById is empty");
            throw new IllegalStateException("No posts yet!");
        }

        return postsById.values().stream().toList();
    }

    public List<Comment> getAllCommentsByPostId(int postId) {
        if (postsById.get(postId).getCommentsById().isEmpty()) {
            log.error("No comments found for post (postId={})", postId);
            throw new IllegalStateException("No comments found for post");
        }
        return Objects.requireNonNull(postsById.get(postId)
                .getCommentsById()
                .values()
                .stream()
                .toList()
        );
    }

    public void removePostById(int postId) {
        if (!Objects.equals(Thread.currentThread().getName(), postsById.get(postId).getAuthor())) {
            log.error("User with no permission name={} trying to delete post id={}",
                    Thread.currentThread().getName(), postId);
            throw new IllegalStateException("You can't delete this post!");
        }
        if (!postsById.containsKey(postId)) {
            log.error("Trying to remove post which doesn't exist (postId={})", postId);
            throw new IllegalArgumentException("Post not found!");
        }
        log.info("Post deleted");
        postsById.remove(postId);
    }

    public void removeComment(int postId, int commentId) {
        Map<Integer, Comment> commentMap = Objects.requireNonNull(postsById.get(postId).getCommentsById());
        if (!Objects.equals(Thread.currentThread().getName(), commentMap.get(commentId).getAuthor())) {
            log.error("User with no permission name={} trying to delete comment id={}",
                    Thread.currentThread().getName(), commentId);
            throw new IllegalStateException("You can't delete this comment!");
        }
        if (!commentMap.containsKey(commentId)) {
            log.error("The comment to remove with id {} not found", commentId);
            throw new IllegalArgumentException("Comment to remove not found");
        }
        log.info("Comment deleted");
        postsById.get(postId).removeComment(commentId);
    }
}
