package faang.school.godbless.sprint5.multithreading_conc.task1_comment;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostService {

    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(int id, Comment comment) {
        synchronized (posts) {
            posts.get(id).getComments().add(comment);
            System.out.println("Коммент " + comment + " добавлен к посту " + id);
        }
    }

    public void addPost(Post post) {
        synchronized (posts) {
            posts.add(post);
            System.out.println("Пост " + post + " добавлен");
        }
    }

    public Post getPostById(int id) {
        return posts.get(id);
    }

    public void deletePost(Post post, String author) {
        if (post.getAuthor().equals(author)) {
            synchronized (posts) {
                posts.remove(post);
                System.out.println("Пост " + post + " удален пользователем " + author);
            }
        } else {
            System.out.println("Вы не можете удалить пост другого пользователя!");
        }
    }

    public void deleteComment(int id, Comment comment, String author) {
        if (comment.getAuthor().equals(author)) {
            synchronized (posts) {
                posts.get(id).getComments().remove(comment);
                System.out.println("Комментарий " + comment + " удален пользователем " + author + " от поста " + id);
            }
        } else {
            System.out.println("Вы не можете удалить комментарий от другого пользователя!");
        }
    }
}
