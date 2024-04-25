package faang.school.godbless.Comments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_POSTS = 20;
    private static final int NUM_COMMENTS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Post> posts = getPosts();
        List<Comment> comments = getComments();
        PostService service = new PostService();

        posts.forEach(post -> pool.execute(() -> service.addPost(post)));
        Thread.sleep(5000);
        service.printPosts();

        posts.forEach(post -> comments.forEach(comment -> pool.execute(() -> service.addComment(post.getId(), comment))));
        Thread.sleep(5000);
        service.printPostsComments();

        posts.forEach(post -> pool.execute(() -> service.removePost(post, post.getAuthor())));
        Thread.sleep(5000);
        service.printPosts();

        pool.shutdown();
    }

    private static List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < NUM_POSTS; i++) {
            posts.add(new Post(i, "HEADER:" + i, "TEXT:" + i, "AUTHOR:" + i));
        }
        return posts;
    }

    private static List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < NUM_COMMENTS; i++) {
            comments.add(new Comment("C_TEXT:" + i, "C_AUTHOR:" + i));
        }
        return comments;
    }
}
