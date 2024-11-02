package school.faang.task4202;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments;

    public Post(int id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
}

class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

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
            Post post = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Пост не найден"));
            post.addComment(comment);
        } finally {
            lock.unlock();
        }
    }

    public void removePost(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int postId, Comment comment, String author) {
        lock.lock();
        try {
            Post post = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Пост не найден"));
            if (comment.getAuthor().equals(author)) {
                post.removeComment(comment);
            }
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }
}

class Donation {
    private final int id;
    private final double amount;

    public Donation(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}

class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        balance.updateAndGet(currentBalance -> currentBalance + donation.getAmount());
    }

    public double getBalance() {
        return balance.get();
    }
}

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        // Симуляция добавления постов и комментариев разными пользователями
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit(() -> {
            Post post = new Post(1, "Заголовок поста 1", "Содержание поста 1", "Автор 1");
            postService.addPost(post);
        });

        executor.submit(() -> {
            Comment comment = new Comment("Отличный пост!", "Пользователь 1");
            postService.addComment(1, comment);
        });

        executor.submit(() -> {
            Comment comment = new Comment("Спасибо за информацию!", "Пользователь 2");
            postService.addComment(1, comment);
        });

        // Симуляция добавления пожертвований
        Organization organization = new Organization();

        IntStream.range(0, 10).forEach(i -> {
            executor.submit(() -> {
                Donation donation = new Donation(i, 100.0);
                organization.addDonation(donation);
            });
        });

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Вывод всех постов и комментариев
        postService.getPosts().forEach(post -> {
            System.out.println("Пост: " + post.getTitle() + " от " + post.getAuthor());
            post.getComments().forEach(comment ->
                    System.out.println("  Комментарий: " + comment.getText() + " от " + comment.getAuthor()));
        });

        // Вывод итогового баланса организации
        System.out.println("Итоговый баланс организации: " + organization.getBalance());
    }
}
