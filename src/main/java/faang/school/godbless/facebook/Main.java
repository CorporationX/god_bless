package faang.school.godbless.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int AMOUNT_POSTS = 20;
    private static final int AMOUNT_COMMENTS = 5;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < AMOUNT_POSTS; i++) {
            posts.add(new Post(i, "" + i, "" + i));
        }
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < AMOUNT_COMMENTS; i++) {
            comments.add(new Comment(i, "" + i));
        }
        PostService service = new PostService();

        posts.forEach(post -> pool.execute(() -> service.addPost(post)));
        Thread.sleep(5000);
        service.printPosts();

        posts.forEach(post -> comments.forEach(comment -> pool.execute(() -> service.addComment(post, comment))));
        Thread.sleep(5000);
        service.printPosts();

        System.out.println("Remove comments stage");
        posts.forEach(post -> comments.forEach(comment -> pool.execute(() -> service.removeComment(post, comment, comment.getAuthor()))));
        Thread.sleep(5000);
        service.printPosts();

        System.out.println("Remove posts stage");
        posts.forEach(post -> pool.execute(() -> service.removePost(post, post.getAuthor())));
        Thread.sleep(5000);
        service.printPosts();

        pool.shutdown();
    }
}
