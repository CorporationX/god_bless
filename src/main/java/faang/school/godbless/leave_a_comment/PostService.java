package faang.school.godbless.leave_a_comment;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    @Getter
    private List<Post> posts = new ArrayList<>();
    Lock lock = new ReentrantLock();

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
            for (Post post : posts) {
                if (post.getTitle().equals("Post " + postId)) {
                    post.addComment(comment);
                    System.out.println("Добавлен комментарий пользователем " + comment.getAuthor() + " к посту с id:" + postId);
                    return;
                }
            }
            System.out.println("Пост для комментария не найден");
        } finally {
            lock.unlock();
        }
    }
}
