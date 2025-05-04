package school.faang.stream4.facebookleavingacomment;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Post post1 = new Post(1, "Пост 1", "Это первый пост", "Автор1");
        Post post2 = new Post(2, "Пост 2", "Это второй пост", "Автор2");
        Post post3 = new Post(3, "Пост 3", "Это третий пост", "Автор1");

        Comment comment1 = new Comment("Это комментарий к первому посту", "Автор3", LocalDateTime.now());
        Comment comment2 = new Comment("Это комментарий к второму посту", "Автор1", LocalDateTime.now());
        Comment comment3 = new Comment("Это комментарий к второму посту", "Автор3", LocalDateTime.now());

        ExecutorService pool = Executors.newCachedThreadPool();

        CompletableFuture.runAsync(() -> postService.addPost(post1), pool).join();
        CompletableFuture.runAsync(() -> postService.addPost(post2), pool).join();
        CompletableFuture.runAsync(() -> postService.addPost(post3), pool).join();

        postService.addComment(1, comment1).join();
        postService.addComment(2, comment2).join();
        postService.addComment(2, comment3).join();

        postService.showPostsOfThisAuthor("Автор1")
                .thenAccept(posts -> {
                    System.out.println("Посты автора 'Автор1':");
                    posts.forEach(post -> System.out.println(post.getContent()));
                }).join();

        postService.showCommentsToPostByPostId(1)
                .thenAccept(comments -> {
                    System.out.println("Комментарии к первому посту:");
                    comments.forEach(comment -> System.out.println(comment.getText()));
                }).join();

        postService.removeCommentByItsAuthorByTimeStamp(1, "Автор3", comment1.getTimeStamp())
                .thenRun(() -> {
                    postService.showCommentsToPostByPostId(1)
                            .thenAccept(comments -> {
                                System.out.println("Комментарии к первому посту после удаления:");
                                comments.forEach(comment -> System.out.println(comment.getText()));
                            }).join();
                })
                .join();

        postService.removePostByPostIdByItsAuthor(2, "Автор2")
                .thenRun(() -> {
                    postService.showPostsOfThisAuthor("Автор2")
                            .thenAccept(posts -> {
                                System.out.println("Посты автора 'Автор2' после удаления поста:");
                                posts.forEach(post -> System.out.println(post.getContent()));
                            }).join();
                })
                .join();

        pool.shutdown();

        try {
            if (!pool.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println(e + " - завершение пула потоков прервано");
            pool.shutdownNow();
        }
    }
}
