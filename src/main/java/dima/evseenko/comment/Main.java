package dima.evseenko.comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();

        Post post = new Post(1, "Igor", "Title", "Content");
        postService.addPost(post);

        ExecutorService executorService = Executors.newCachedThreadPool();

        getComments().forEach(comment -> executorService.submit(() -> postService.addComment(1, comment)));

        executorService.shutdown();

        if (executorService.awaitTermination(100, TimeUnit.SECONDS)) {
            postService.printPosts();
            postService.printComments(1);

            postService.deleteComment(1, 1);
            postService.printComments(1);

            postService.deletePost(1);
            postService.printPosts();
        }
    }

    private static List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            comments.add(new Comment(i, "Author " + i, "Text " + i));
        }

        return comments;
    }
}
