package faang.school.godbless.leaveComment;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Comment> newComments = new ArrayList<>();
        List<Post> newPosts = new ArrayList<>();
        PostService postService = new PostService();

        for (int i = 0; i < 100; i++) {
            newComments.add(new Comment("comment №" + i, new GregorianCalendar(), "Author of comment №" + i));
        }
        for (int i = 0; i < 10; i++) {
            newPosts.add(new Post("post " + i, "text", "post's author - " + i));
        }

        ExecutorService executorForPosts = Executors.newFixedThreadPool(2);
        ExecutorService executorForComments = Executors.newFixedThreadPool(4);
        Future futurePosts = new CompletableFuture();
        Future futureComments = new CompletableFuture();
        for (var post : newPosts){
            futurePosts = executorForPosts.submit(() -> postService.addPost(post));
        }
        executorForPosts.shutdown();
        for(var comment : newComments){
            futureComments = executorForComments.submit(() -> postService.addComment(comment, (int)Math.ceil(Math.random() * 10)));
        }
        executorForComments.shutdown();
        futurePosts.get();
        futureComments.get();

        postService.getPostsComments(3).forEach(System.out::println);

        Comment commentForRefactor = postService.getPostsComments(5).get(3);
        postService.refactorComment(5, commentForRefactor.getAuthor(), commentForRefactor.getText(), "new text");

        Comment commentForRemove = postService.getPostsComments(4).get(3);
        postService.removeComment(4, commentForRemove.getAuthor(), commentForRemove.getText());

    }
}
