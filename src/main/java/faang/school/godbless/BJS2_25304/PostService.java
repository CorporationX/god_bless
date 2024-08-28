package faang.school.godbless.BJS2_25304;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Getter
public class PostService {
    private List<Post> posts;
    private static final Object LOCKER_COMMENTS = new Object();
    private static final Object LOCKER_POSTS = new Object();

    public PostService() {
        this.posts = new ArrayList<>();
    }

    public void addComment(Comment comment, int id) {
        synchronized (LOCKER_COMMENTS) {
            posts
                    .stream()
                    .filter(postFromList -> postFromList.id() == id)
                    .findFirst()
                    .map(postFromList -> {
                        postFromList.addComment(comment);
                        return postFromList;
                    })
                    .orElseThrow(() -> new IllegalArgumentException("Post with id " + id + " doesn't exist"));

        }
    }

    public void addPost(Post post) {
        synchronized (LOCKER_POSTS) {
            posts.add(post);
        }
    }

    public void deletePost(int id) {
        posts.removeIf(post -> {
            if (post.id() == id && post.author().equals(Thread.currentThread().getName())) {
                log.info("Post written by {} with id {} was deleted by {}", post.author(), id, Thread.currentThread().getName());
                return true;
            } else {
                log.info("{} is not author of id {}, need {}", Thread.currentThread().getName(), id, post.author());
                return false;
            }
        });
    }

    public synchronized void deleteComments(int postId) {
        Optional
                .ofNullable(posts.get(postId))
                .ifPresentOrElse((post) -> {
                    post.comments()
                            .stream()
                            .filter(comment -> comment.author().equals(Thread.currentThread().getName()))
                            .findFirst()
                            .ifPresent(comment -> {
                                log.info("Comment with author {} was deleted by author {}", comment.author(), Thread.currentThread().getName());
                                post.comments().remove(comment);
                            });
                }, () -> log.error("Post with id {} does not exist", postId));
    }
}
