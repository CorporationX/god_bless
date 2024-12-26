package school.faang.sprint4.task_51150;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            log.info("New post was added {}", post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            List<Comment> comments = post.getComments();
            comments.add(comment);
            log.info("New comment to post with id = {}. By user = {}. Text: {}",
                    postId, comment.getAuthor(), comment.getText());
        } finally {
            lock.unlock();
        }
    }

    public void viewPost(int postId) {
        Post post = posts.get(postId);
        printPostData(post);
    }

    public void printAllPosts() {
        posts.forEach(post -> {
            printPostData(post);
            System.out.println("-----".repeat(10) + "\n");
        });
    }

    public void deletePost(String user, int postId) {
        lock.lock();
        try {
            Post post = posts.get(postId);

            if (Objects.equals(post.getAuthor(), user)) {
                posts.remove(post);
                log.info("Post with id = {} was removed", postId);
                return;
            }
            log.info("{} attempted to delete post with id = {}. Don't have permission", user, postId);
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(String user, int postId, int commentId) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            List<Comment> comments = post.getComments();
            Comment comment = comments.get(commentId);

            if (Objects.equals(comment.getAuthor(), user)) {
                comments.remove(comment);
                log.info("{} was removed from post with id = {}. By: {}", comment, post.getId(), user);
                return;
            }
            log.info("{} attempted to delete comment with id = {} from post with id = {}. Don't have permission",
                    user, commentId, postId);
        } finally {
            lock.unlock();
        }
    }

    private void printPostData(Post post) {
        List<Comment> comments = post.getComments();
        System.out.println(post.getId() + " " + post.getTitle() + " " + post.getAuthor());
        System.out.println(post.getContent());
        if (!comments.isEmpty()) {
            System.out.println("Comments: ");
            comments.forEach(System.out::println);
        }
    }
}
