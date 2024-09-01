package faang.school.godbless.BJS2_25288;

import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class PostService {
    private final Lock lock = new ReentrantLock(true);
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            var foundPost = posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findAny()
                    .orElseThrow(() -> new NoSuchElementException("Post not found"));

            if (foundPost != null) {
                foundPost.addComment(comment);
            }

        } finally {
            lock.unlock();
        }
    }


    public void viewPost(int postId) {
        lock.lock();

        try {
            var foundPost = posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findAny()
                    .orElseThrow(() -> new NoSuchElementException("Post not found"));

            System.out.println("===========================================");
            System.out.printf("%s\t %s\n", foundPost.getTitle(), foundPost.getAuthor());

            if (foundPost.getComments().isEmpty()) {
                System.out.println("No comments for " + foundPost.getTitle());
            }

            for (int i = 0; i < foundPost.getComments().size(); i++) {
                var comment = foundPost.getComments().get(i);
                System.out.printf("\t%s\n", comment.getAuthor());
                System.out.printf("\t\t%s\t%s\n", comment.getComment(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(comment.getDateTime()));

                if (i != foundPost.getComments().size() - 1)
                    System.out.println("-------------------------------------------");
            }

        } finally {
            lock.unlock();
        }
    }
}
