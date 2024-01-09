package faang.school.godbless.BJS2_1382;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        User user1 = new User("Edisolt");
        User user2 = new User("Inna Mishustina");

        Post post1 = new Post("Java Bootcamp", "What do I think it was like", user1, new ArrayList<>());
        Post post2 = new Post("Java Bootcamp", "I hate students", user2, new ArrayList<>());

        postService.addPost(post1);
        postService.addPost(post2);

        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> {
                    Comment comment2 = new Comment("We respect u", user1);
                    postService.addComment(post1, comment2);
                }),
                CompletableFuture.runAsync(() -> {
                    Comment comment1 = new Comment("I hate u", user2);
                    postService.addComment(post2, comment1);
                })
        ).join();

        for (var post : postService.getPosts().entrySet()) {
            System.out.println("Post ID: " + post.getValue().getId());
            for (Comment comment : post.getValue().getComments()) {
                System.out.println("  Comment: " + comment.getComment() + " by " + comment.getAuthor().getName());
            }
        }
    }
}