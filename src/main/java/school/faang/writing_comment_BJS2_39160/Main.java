package school.faang.writing_comment_BJS2_39160;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AWAITING_TIME = 3;
    private static final int COMMENTS_POSTS_COUNT = 5;

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        PostService postService = new PostService();

        List<Comment> comments = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < COMMENTS_POSTS_COUNT; i++) {
            String author = "Author" + i;
            comments.add(new Comment("Text" + i, author, LocalDateTime.now()));
            posts.add(new Post(i, "Title" + i, "Content" + i, author, comments));
        }
        posts.forEach(post -> service.submit(() -> postService.addPost(post)));
        comments.forEach(comment -> service.submit(() -> {
            for (Post post : posts) {
                postService.addComment(post.getId(), comment);
            }
        }));

        service.submit(() -> postService.showPost(posts.get(0)));
        service.submit(() -> postService.deletePost(posts.get(0), "John Doe"));
        service.submit(() -> postService.showComment(posts.get(0), comments.get(0)));
        service.submit(() -> postService.deleteComment(posts.get(3), comments.get(0), comments.get(0).getAuthor()));

        service.shutdown();
        try {
            if (service.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES))
                System.out.println(postService.getPosts());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
