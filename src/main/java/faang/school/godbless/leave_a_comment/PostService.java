package faang.school.godbless.leave_a_comment;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Slf4j
public class PostService {
    private Map<Integer, Post> posts;

    public PostService() {
        this.posts = new ConcurrentHashMap<>();
    }

    public void addComment(Comment comment) {
        Post post = posts.get(comment.getPostId());
        synchronized (post) {
            post.addComment(comment);
        }
    }

    public void addPost(Post post) {
        posts.put(post.getId(), post);
    }

    public void deleteComment(Comment comment, User author) {
        if (!author.equals(comment.getAuthor())) {
            log.error("This is not your comment, you cannot delete it");
        } else {
            Post post = posts.get(comment.getPostId());
            synchronized (post) {
                post.deleteComment(comment);
            }
        }
    }

    public void deletePost(Post post, User author) {
        if (!post.getAuthor().equals(author)) {
            log.error("This is not your post, you cannot delete it");
        } else {
            posts.remove(post.getId());
        }
    }
}