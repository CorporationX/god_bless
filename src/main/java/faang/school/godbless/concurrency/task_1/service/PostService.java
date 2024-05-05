package faang.school.godbless.concurrency.task_1.service;

import faang.school.godbless.concurrency.task_1.model.Comment;
import faang.school.godbless.concurrency.task_1.model.Post;
import faang.school.godbless.concurrency.task_1.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private static volatile Map<Integer, Post> storage = new ConcurrentHashMap<>();

    public void addPost(Post post) {
        int postId = ID_GENERATOR.incrementAndGet();
        post.setPostId(postId);
        storage.put(postId, post);
        System.out.println("добавлен пост " + post.getHeader());
    }

    public Post getPost(int id) {
        return storage.get(id);
    }

    public void addComment(Comment comment) {
        LOCK.lock();
        try {
            Post post = findById(comment.getPostId());
            if (post != null) {
                post.getComments().add(comment);
                System.out.println("добавлен комментарий " + comment.getText() + " к посту " + post.getHeader());
            } else {
                System.err.println("пост не найден");
            }
        } finally {
            LOCK.unlock();
        }
    }

    public void deletePost(Post post, User author) {
        if (!post.getAuthor().equals(author)) {
            System.err.println("удаление невозможно вы не автор поста");
        } else {
            storage.remove(post.getPostId());
            System.out.println("пост " + post.getHeader() + " удален пользователем " + author.getUsername());
        }
    }

    public void deleteComment(Comment comment, User author) {
        if (!author.equals(comment.getAuthor())) {
            System.err.println("удаление невозможно вы не автор комментария");
        } else {
            Post post = findById(comment.getPostId());
            LOCK.lock();
            post.getComments().remove(comment);
            System.out.println("комментарий " + comment.getText() + " удален пользователем " + author.getUsername());
            LOCK.unlock();
        }
    }

    private Post findById(int id) {
        return storage.get(id);
    }
}