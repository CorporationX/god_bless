package faang.school.godbless.multi_con.task1comment;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

@Getter
public class PostService {
    private volatile  List<Post> posts = new CopyOnWriteArrayList<>();
    private final Lock lock = new ReentrantLock();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            System.out.println(LocalDateTime.now().format(formatter) + " - Пост " + post.getTitle() + " добавлен");
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            post.getComments().add(comment);
            System.out.println(LocalDateTime.now().format(formatter) + " - Комментарий " + comment.getText() + " добавлен к посту " + post.getTitle());
        } finally {
            lock.unlock();
        }
    }
}
