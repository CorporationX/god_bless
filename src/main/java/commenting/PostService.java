package commenting;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Slf4j
public class PostService {
    public static final String NO_POST = "Don't have post with this id!";
    public static final String ALREADY_HAS_POST = "Posts already in service";
    public static final String NO_COMMENT = "Don't have post with this id!";
    private final Map<Integer, Object> postLocks = new HashMap<>();
    private final Map<Integer, Post> postIdx = new HashMap<>();
    private final Map<Integer, Integer> commentIdx = new HashMap<>();


    public synchronized void addPost(@NonNull Post post) {
        if (!postLocks.containsKey(post.getId())) {
            postLocks.put(post.getId(), new Object());
            postIdx.put(post.getId(), post);
        } else {
            log.error(post.getId() + " " + post.getHeader());
            throw new IllegalArgumentException(ALREADY_HAS_POST);
        }
    }

    public void addComment(@NonNull Comment comment, int id) {
        if (!postIdx.containsKey(id)) {
            log.error(comment.getId() + " post: " + id);
            throw new IllegalArgumentException(NO_POST);
        }
        synchronized (postLocks.get(id)) {
            postIdx.get(id).addComment(comment);
            commentIdx.put(comment.getId(), id);
            /*if (id == 1) {
                log.info("Comment " + comment.getId() + " added to " + postIdx.get(id).getHeader());
            }*/
        }
    }

    public synchronized Post getPost(int id) {
        return postIdx.get(id);
    }

    public synchronized void removePost(int id, @NonNull String author) {
        if (!postIdx.containsKey(id)) {
            log.error("post: " + id);
            throw new IllegalArgumentException(NO_POST);
        }
        if (postIdx.get(id).getAuthor().equals(author)) {
            postIdx.remove(id);
            postLocks.remove(id);
            var idSet = new HashSet<>(commentIdx.keySet());
            for (Integer commentId : idSet) {
                if (commentIdx.get(commentId) == id) {
                    commentIdx.remove(commentId);
                }
            }
        } else {
            throw new IllegalArgumentException("Post can be deleted only by its author!");
        }
    }

    public void removeComment(int id, @NonNull String author) {
        if (!commentIdx.containsKey(id)) {
            throw new IllegalArgumentException(NO_COMMENT);
        }
        int postId;
        synchronized (this) {
            postId = commentIdx.get(id);
        }
        if (postIdx.containsKey(postId)) {
            synchronized (postLocks.get(postId)) {
                postIdx.get(postId).removeComment(id, author);
            }
        } else {
            throw new IllegalArgumentException(NO_POST);
        }
    }

    public synchronized List<Integer> getAllPostsId() {
        return postIdx.keySet().stream().toList();
    }
}
