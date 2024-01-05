package FacebookComments;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Object postLock = new Object();
    private final Object commentLock = new Object();

    public void addComment(int id, Comment comment) {
        synchronized (commentLock) {
            posts.get(id).getComments().add(comment);
            System.out.println("Comment added");
        }
    }

    public void addPost(Post post) {
        synchronized (postLock) {
            posts.add(post);
            System.out.println("Post added");
        }
    }

    //просмотр поста
    public void showPost(int id) {
        synchronized (postLock) {
            System.out.println(posts.get(id));
        }
    }

    //просмотр комментария
    public void showComment(int postId, int commentId) {
        synchronized (commentLock) {
            System.out.println(posts.get(postId).getComments().get(commentId));
        }
    }

    //удаление поста
    public void deletePost(int postId, String author) {
        synchronized (postLock) {
            if (posts.get(postId).getAuthor().equals(author)) {
                posts.remove(postId);
                System.out.println("Пост с id " + postId + " удален автором");
            } else {
                System.out.println("Пости с id " + postId + " не найден/не соответствует автор");
            }
        }
    }

    //удаление комментария
    public void deleteComment(int postId, int commentId, String author) {
        synchronized (commentLock) {
            if (posts.get(postId).getComments().get(commentId).getAuthor().equals(author)) {
                posts.get(postId).getComments().remove(commentId);
                System.out.println("Комментарий с id " + commentId + " удален автором");
            } else {
                System.out.println("Комментарий не найден/не соответствует автор");
            }
        }
    }
}
