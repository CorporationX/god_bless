package school.faang.bjs2_75935;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final AtomicInteger postCount = new AtomicInteger(0);
    private final List<Post> posts = new ArrayList<>();
    private final ReentrantLock postLock = new ReentrantLock();

    /**
     * Методы для работы с постами
     */
    //Содержать метод **addPost(Post post)**, который добавляет пост в список.
    // Используйте блокировку **(lock)** для обеспечения безопасности данных.
    public void addPost(String title, String content, Author author) {
        Post post = new Post(getNextPostId(), title, content, author);
        postLock.lock();
        try {
            log.info("add post: {}-{}", post.getId(), post.getTitle());
            posts.add(post);
        } finally {
            log.info("unlock by post {}-{}", post.getId(), post.getTitle());
            postLock.unlock();
        }
    }

    private void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> findAllPosts() {
        postLock.lock();
        try {
            return new ArrayList<>(posts);
        } finally {
            postLock.unlock();
        }
    }

    //Показать post по его id
    public Optional<Post> findPostById(Integer postId) {
        postLock.lock();
        try {
            return getPostById(postId);
        } finally {
            postLock.unlock();
        }
    }

    //Список постов конкретного автора
    public List<Post> findAllPostsByAuthor(Author author) {
        postLock.lock();
        try {
            return posts.stream()
                .filter(Objects::nonNull)
                .filter(post -> author.equals(post.getAuthor()))
                .toList();
        } finally {
            postLock.unlock();
        }
    }

    //удаление поста по его id
    public void deletePostById(Integer postId, Author author) {
        postLock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && author.equals(post.getAuthor()));
        } finally {
            postLock.unlock();
        }
    }

    public int getPostCount() {
        return posts.size();
    }

    /**
     * Методы для работы с комментариями
     */
    //Содержать метод **addComment(int postId, Comment comment)**, который добавляет комментарий к
    // посту по его идентификатору. Для обеспечения безопасности данных при добавлении комментариев
    // также используйте блокировку **(lock)**.
    public void addComment(Integer postId, String text, Author author) {
        Comment comment = new Comment(text, author, LocalDateTime.now());
        postLock.lock();
        try {
            getPostById(postId)
                .ifPresent(post -> post.addComment(comment));
        } finally {
            postLock.unlock();
        }
    }

    //Список всех комментариев по конкретному посту
    public List<Comment> findAllCommentByPostId(Integer postId) {
        postLock.lock();
        try {
            return getPostById(postId)
                .stream()
                .flatMap(post -> post.getComments().stream())
                .toList();
        } finally {
            postLock.unlock();
        }
    }

    //Удаление комментария
    public void deleteComment(Integer postId, LocalDateTime date, Author author) {
        postLock.lock();
        try {
            getPostById(postId)
                .ifPresent(post -> {
                    post.getComments()
                        .stream()
                        .filter(c -> c.getTimestamp().equals(date) && c.getAuthor().equals(author))
                        .findFirst()
                        .ifPresent(post::deleteComment);
                });
        } finally {
            postLock.unlock();
        }
    }

    private int getNextPostId() {
        return postCount.incrementAndGet();
    }

    private Optional<Post> getPostById(Integer postId) {
        return posts.stream()
            .filter(Objects::nonNull)
            .filter(post -> post.getId() == postId)
            .findFirst();
    }
}
