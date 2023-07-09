package faang.school.godbless.comment;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class PostService {
    private volatile Map<Integer, User> usersMap = new HashMap<>(Map.of( // хранилище пользователей
            1, new User("Fedor", 33),
            2, new User("Nikita", 33),
            3, new User("Petya", 33),
            4, new User("upol", 33),
            5, new User("ferein", 33)
    ));

    private volatile Map<Integer, Comment> commentsMap = new HashMap<>(); // хранилище комментариев
    private volatile Map<Integer, Post> postsMap = new HashMap<>(); // хранилище постов

    private final Lock lock = new ReentrantLock();

    public CompletableFuture<Void> addPost(Post post) {
        lock.lock();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            System.out.println("Creating new post: " + post.getHeader() + " by author: " + post.getAuthor().getUsername());

            return CompletableFuture.runAsync(() -> {
                postsMap.put(post.getId(), post); // добавление поста в хранилище
                usersMap.get(post.getAuthor().getId()).getPosts().add(post); // добавление поста пользователю
            }, executorService);
        } finally {
            lock.unlock();
        }
    }

    public CompletableFuture<Void> deletePost(int postId, int userId) {
        processInputs(postId, userId);

        if (userId != postsMap.get(postId).getAuthor().getId()) {
            throw new IllegalArgumentException("Post can be deleted only by author");
        }

        lock.lock();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            Post postToDelete = postsMap.get(postId);

            System.out.println("Deleting post: " + postToDelete.getHeader());

            return CompletableFuture.runAsync(() -> {
                postsMap.remove(postId); // удаление поста из хранилища
                usersMap.get(userId).getPosts().remove(postToDelete); // удаление поста у юзера
            }, executorService);
        } finally {
            lock.unlock();
        }
    }

    public CompletableFuture<Void> checkPost(int postId) {
        processInputs(postId);

        lock.lock();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            return CompletableFuture.runAsync(() -> {
                System.out.println("Checking post: " + postsMap.get(postId).getHeader() +
                        " by author: " + postsMap.get(postId).getAuthor().getUsername());
            }, executorService);
        } finally {
            lock.unlock();
        }
    }

    public CompletableFuture<Void> addComment(int postId, Comment comment, int userId) {
        processInputs(postId, userId);

        lock.lock();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            Post postToUpdate = postsMap.get(postId);
            User userToUpdate = usersMap.get(userId);

            System.out.println("Creating new comment at post: " + postToUpdate.getHeader() +
                    ": " + comment.getText());

            return CompletableFuture.runAsync(() -> {
                commentsMap.put(comment.getId(), comment); // добавляем пост в хранилище
                comment.setAuthor(userToUpdate); // у поста ставим автора
                postToUpdate.getComments().add(comment); // обновляем комментарии поста
                userToUpdate.getComments().add(comment); // обновляем комментарии человека
            }, executorService);
        } finally {
            lock.unlock();
        }
    }

    public CompletableFuture<Void> deleteComment(int postId, int commentId, int userId) { ///
        processInputs(postId, commentId, userId);

        if (userId != commentsMap.get(commentId).getAuthor().getId()) {
            throw new IllegalArgumentException("Comment can be deleted only by author");
        }

        lock.lock();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            Comment foundComment = commentsMap.get(commentId);
            Post postToUpdate = postsMap.get(postId);
            User userToUpdate = usersMap.get(userId);

            System.out.println("Deleting comment: " + foundComment.getText() + " at post: " + postToUpdate.getHeader() +
                    " by author: " + foundComment.getAuthor().getUsername());

            return CompletableFuture.runAsync(() -> {
                commentsMap.remove(commentId); // удаление из хранилища комментариев
                postToUpdate.getComments().remove(foundComment); // удаление комментария из поста
                userToUpdate.getComments().remove(foundComment); // удаление комментария у человека
            }, executorService);
        } finally {
            lock.unlock();
        }
    }

    public CompletableFuture<Void> checkComment(int postId, int commentId) {
        processInputs(postId, commentId);

        lock.lock();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            Comment foundComment = commentsMap.get(commentId);

            return CompletableFuture.runAsync(() -> {
                System.out.println("Checking comment: " + foundComment.getText() +
                        " at post: " + postsMap.get(postId).getHeader() + " by author: " + foundComment.getAuthor().getUsername());
            }, executorService);
        } finally {
            lock.unlock();
        }
    }

    public void processInputs(int postId, int userId) {
        if (!postsMap.containsKey(postId)) {
            throw new IllegalArgumentException("There is no such posts");
        }

        if (!usersMap.containsKey(userId)) {
            throw new IllegalArgumentException("There is no such users");
        }
    }

    public void processInputs(int postId, int commentId, int userId) {
        if (!postsMap.containsKey(postId)) {
            throw new IllegalArgumentException("There is no such posts");
        }

        if (!commentsMap.containsKey(commentId)) {
            throw new IllegalArgumentException("There is no such comments");
        }

        if (!usersMap.containsKey(userId)) {
            throw new IllegalArgumentException("There is no such users");
        }
    }

    public void processInputs(int postId) {
        if (!postsMap.containsKey(postId)) {
            throw new IllegalArgumentException("There is no such posts");
        }
    }


}
