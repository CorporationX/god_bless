package school.faang.task_62690;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        // Создание постов
        Post firstPost = new Post(1, "post1", "This is the first post", "author1", new ArrayList<>());
        Post secondPost = new Post(2, "post2", "This is the second post", "author2", new ArrayList<>());

        // Добавление постов
        postService.addPost(firstPost);
        postService.addPost(secondPost);

        // Проверка, что посты добавлены
        System.out.println("Posts after addition:");
        postService.getPosts("Author1").forEach(post -> System.out.println(post.getContent()));
        postService.getPosts("Author2").forEach(post -> System.out.println(post.getContent()));

        // Создание комментариев
        Comment comment1 = new Comment("Author1", "Great post!", LocalDateTime.now());
        Comment comment2 = new Comment("Author2", "Thanks for sharing!", LocalDateTime.now());

        // Добавление комментариев
        postService.addComment(0, comment1); // Добавляем комментарий к первому посту
        postService.addComment(1, comment2); // Добавляем комментарий ко второму посту

        // Проверка, что комментарии добавлены
        System.out.println("\nComments for Post 1:");
        postService.getComments(firstPost.getId()).forEach(comment -> System.out.println(comment.getText()));

        System.out.println("\nComments for Post 2:");
        postService.getComments(secondPost.getId()).forEach(comment -> System.out.println(comment.getText()));

        // Удаление комментария
        postService.deleteComment(1, "Author2", comment2.getTimestamp());
        System.out.println("\nComments for Post 2 after deletion:");
        postService.getComments(secondPost.getId()).forEach(comment -> System.out.println(comment.getText()));

        // Удаление поста
        postService.deletePosts(1, "Author1");
        System.out.println("\nPosts after deletion:");
        postService.getPosts("Author1").forEach(post -> System.out.println(post.getContent()));
    }
}


