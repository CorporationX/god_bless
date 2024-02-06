package faang.school.godbless.LeaveComment;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class PostService {
    private volatile List<Post> posts;
    private static Lock postLock = new ReentrantLock();

    public PostService(List<Post> posts) {
        this.posts = posts;
    }

    public void addComment(Post post, Comment comment) {
        postLock.lock();
        try {
            for (Post position : posts) {
                if (position.getId() == post.getId()) {
                    position.getComments().add(comment);
                    System.out.println(comment.getAuthor() + comment.getComment() + " добавлен к посту " + position.getId()
                            + " дата: " + comment.getDateTime());
                }
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            postLock.unlock();
        }
    }

    public void addPost(Post post) {
        postLock.lock();
        try {
            posts.add(post);
            System.out.println(post.getId() + " " + post.getTitle() + " добавлен");
        } finally {
            postLock.unlock();
        }
    }

    public void viewingPosts(int id) {
        postLock.lock();
        try {
            for (Post position : posts) {
                if (position.getId() == id) {
                    System.out.println("Вы смотрите пост: ");
                    System.out.println(position.toString());
                }
            }
        } finally {
            postLock.unlock();
        }
    }


    public void deleteComment(String author, String comment, int id) {
        postLock.lock();
        try {
            posts.stream()
                    .filter(post -> post.getId() == id)
                    .findFirst()
                    .ifPresentOrElse(
                            post -> {
                                if (post.getComments().removeIf(com -> com.getComment().equals(comment) && com.getAuthor().equals(author)))
                                    System.out.println("Удаляем комментарий: " + comment + " к посту " + post.getId());
                                else System.out.println("Такого комментария этого автора нет");
                            },
                            () -> System.out.println("Пост с id " + id + " не найден")
                    );
        } finally {
            postLock.unlock();
        }
    }
}
