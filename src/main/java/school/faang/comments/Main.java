package school.faang.comments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        PostService postService = new PostService();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 15; i++) {
            int idPost = i;
            executorService.submit(() -> {
                Post post = new Post(idPost,
                        "Header " + idPost,
                        "Text " + idPost,
                        "Author " + idPost,
                        new ArrayList<>());
                postService.addPost(post);
            });
        }
        for (int i = 0; i < 15; i++) {
            int idPost = i;
            executorService.submit(() -> {
                Comment comment = new Comment("Text " + idPost, "author" + idPost, LocalDate.now());
                postService.addComment(idPost, comment);
            });
        }
        for (int i = 0; i < 4; i++) {
            int idPost = i;
            executorService.submit(() -> {
                Comment comment = new Comment("Text " + idPost + 10, "author" + idPost + 10, LocalDate.now());
                postService.addComment(idPost, comment);
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(4000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Show comments for post id 1:" + postService.readComments(1));
        postService.deleteComment(1, "author1");
        System.out.println("Show comments for post id 1 after deleted comment:" + postService.readComments(1));
        postService.deletePost(1);
        System.out.println("Show comments for post id 1: " + postService.readComments(1));
        postService.addComment(999, new Comment("test", "test1", LocalDate.now()));
    }
}