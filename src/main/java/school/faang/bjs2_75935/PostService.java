package school.faang.bjs2_75935;

import school.faang.bjs2_69541.Category;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private static final String TITLE_IS_EMPTY = "Title is empty";
    private static final String AUTHOR_IS_EMPTY = "Author is empty";
    private static final String CONTENT_IS_EMPTY = "Content is empty";

    private final AtomicInteger postId = new AtomicInteger(0);
    private final List<Post> posts = new ArrayList<>();
    private final ReentrantLock postLock = new ReentrantLock();

    /**
     * Методы для работы с постами
     */
    //Содержать метод **addPost(Post post)**, который добавляет пост в список. Используйте блокировку **(lock)** для обеспечения безопасности данных.
    public void addPost(String title, String content, Author author) {
        validatePostData(title, content, author);
        Post post = new Post(getPostId(), title, content, author);
        postLock.lock();
        try {
            posts.add(post);
        } finally {
            postLock.unlock();
        }
    }

    //Показать post по его id
    public Optional<Post> findPostById(Integer postId) {
        postLock.lock();
        try {
            return posts.stream()
                .filter(Objects::nonNull)
                .filter(post -> post.getId() == postId)
                .findFirst();
        } finally {
            postLock.unlock();
        }
    }

    //Список постов конкретного автора
    public List<Post> findAllPosts(Author author) {
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

    /**
     * Методы для работы с комментариями
     */
    //Содержать метод **addComment(int postId, Comment comment)**, который добавляет комментарий к посту по его идентификатору. Для обеспечения безопасности данных при добавлении комментариев также используйте блокировку **(lock)**.
    public void addComment(Integer postId, String text, Author author) {
        findPostById(postId).ifPresent(post -> {
            postLock.lock();
            try {
                //todo: ??? сделать проверку комментария здесь или в классе Comment ???
                post.addComment(....);
            } finally {
                postLock.unlock();
            }
        });
    }

    //Список всех комментариев по конкретному посту
    public List<Comment> findAllCommentByPost(Post post) {
        return new ArrayList<>();
    }

    //Удаление комментария
    public void deleteComment(LocalDateTime date, Author author) {
    }

    private void addPost(Post post) {
        posts.add(post);
    }

    private int getPostId() {
        return postId.incrementAndGet();
    }

    private void validatePostData(String title, String content, Author author) {
        StringBuilder error = new StringBuilder();
        if (title == null || title.isBlank()) {
            appendError(error, TITLE_IS_EMPTY);
        }
        if (content == null || content.isBlank()) {
            appendError(error, CONTENT_IS_EMPTY);
        }
        if (author == null) {
            appendError(error, AUTHOR_IS_EMPTY);
        }
        if (!error.isEmpty()) {
            throw new NoSuchElementException(error.toString());
        }
    }

    private void appendError(StringBuilder error, String errorMessage) {
        if (!error.isEmpty()) {
            error.append(" ");
        }
        error.append(errorMessage);
    }
}
