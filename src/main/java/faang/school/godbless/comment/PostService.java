package faang.school.godbless.comment;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class PostService {

    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(Comment comment, int id) {
        Optional<Post> post = posts.stream()
                .filter(post1 -> post1.getId() == id)
                .findFirst();
        synchronized (this) {
            post.ifPresentOrElse(post1 -> {
                post1.getComments().add(comment);
                log.info("Comment by user {} to post id {}", comment.getAuthor(), post1.getId());
            }, () -> log.info("post not found, id {}", id));
        }
    }

    public synchronized void addPost(Post post) {
        log.info("new post {}", post.getId());
        posts.add(post);
    }

    public Optional<Post> getPost(int id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst();
    }

    public synchronized void deletePost(int id) {
        Optional<Post> optional = posts.stream().filter(post1 -> post1.getId() == id).findFirst();

        if (optional.isPresent() && optional.get().getAuthor().equals(Thread.currentThread().getName())) {
            posts.remove(optional.get());
            log.info("DELETE POST | post with id {} deleted", id);
        } else {
            log.info("DELETE POST | {} is not author, post id {}", Thread.currentThread().getName(), id);
        }
    }

    public void deleteComment(int postId, String username) {
        if (postId >= posts.size()) {
            log.info("DELETE COMMENT | post with id {} not found", postId);
        }

        synchronized (this) {
            Optional<Post> optionalPost = getPost(postId);

            if (optionalPost.isPresent()) {
                Post post = optionalPost.get();
                Optional<Comment> optionalComment = post.getComments().stream()
                        .filter(comment -> comment.getAuthor().equals(username))
                        .findFirst();

                optionalComment.ifPresentOrElse(comment -> {
                    post.getComments().remove(comment);
                    log.info("DELETE COMMENT | user {} delete comment {}, from post id {}", username, comment.getText(), postId);
                }, () -> log.info("DELETE COMMENT | this user {} dont have comment, post id {}", username, postId));
            }
        }
    }
}
