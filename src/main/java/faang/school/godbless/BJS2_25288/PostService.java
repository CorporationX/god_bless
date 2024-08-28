package faang.school.godbless.BJS2_25288;

import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class PostService {
    private final Lock lock = new ReentrantLock();
    private volatile List<Post> posts = new ArrayList<>();

    public synchronized void addPost(Post post) {
        lock.lock();

        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public synchronized void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                post.getComments().add(comment);
            }
        } finally {
            lock.unlock();
        }
    }


    public synchronized void viewPost(int postId) {
        lock.lock();
        try {
            var post = posts.get(postId);
            System.out.println("===========================================");
            System.out.printf("%s\t %s\n", post.getTitle(), post.getAuthor());

            if (post.getComments().isEmpty()) {
                System.out.println("No comments for " + post.getTitle());
            }

            for (int i = 0; i < post.getComments().size(); i++) {
                var comment = post.getComments().get(i);
                System.out.printf("\t%s\n", comment.getAuthor());
                System.out.printf("\t\t%s\t%s\n", comment.getComment(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(comment.getDateTime()));

                if (i != post.getComments().size() - 1)
                    System.out.println("-------------------------------------------");
            }
        } finally {
            lock.unlock();
        }
    }
}
