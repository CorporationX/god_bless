package faang.school.godbless.bjs2_25421;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Lock postLock = new ReentrantLock(true);

    public void addPost(Post post) {
        postLock.lock();
        try {
            posts.put(post.getId(), post);
            log.info("Post {} was added", post.getId());
        } finally {
            postLock.unlock();
        }
    }

    public List<Post> readAllPosts() {
        postLock.lock();
        try {
            return posts.values().stream().toList();
        } finally {
            postLock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        postLock.lock();
        try {
            var post = posts.get(postId);
            if (!post.getAuthor().equals(author)) {
                log.info("{} have no access to delete Post {}", author, postId);
            } else {
                posts.remove(postId);
                log.info("Post {} have been deleted by {}", postId, author);
            }
        } finally {
            postLock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        Post addedComment = posts.computeIfPresent(postId, (id, post) -> {
            post.addComment(comment);
            return post;
        });
        if (addedComment == null) {
            log.info("Post {} was deleted while adding comment {}", postId, comment.getText());
        }
    }

    public void deleteComment(int postId, int commentId, String author) {
        Post success = posts.computeIfPresent(postId, (id, post) -> {
            post.deleteComment(commentId, author);
            return post;
        });
        if (success == null) {
            log.info("Post {} was deleted while deleting comment {} by author {}", postId, commentId, author);
        }
    }

    public List<Comment> readAllComments(int postId) {
        Optional<Post> post = findById(postId);
        if (post.isPresent()) {
            return post.map(Post::getComments).orElse(List.of());
        } else {
            log.info("Post with id " + postId + " doesn't exists");
            return List.of();
        }
    }

    private Optional<Post> findById(int postId) {
        return Optional.ofNullable(posts.get(postId));
    }
}
