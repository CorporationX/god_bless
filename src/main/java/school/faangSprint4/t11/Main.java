package school.faangSprint4.t11;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Thread user1 = new Thread(() -> {
            Post post1 = new Post(1, "First Post", "Content 1", "User1");
            postService.addPost(post1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            postService.addComment(1, new Comment("Great post!", "User2"));
        });

        Thread user2 = new Thread(() -> {
            Post post2 = new Post(2, "Second Post", "Content 2", "User2");
            postService.addPost(post2);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            postService.addComment(1, new Comment("Nice content!", "User1"));
        });

        Thread user3 = new Thread(() -> {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            postService.addComment(2, new Comment("Interesting!", "User3"));
        });

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll Posts and Comments:");
        for (Post post : postService.getAllPosts()) {
            System.out.println("\nPost: " + post.getTitle() + " by " + post.getAuthor());
            List<Comment> comments = postService.getPostComments(post.getId());
            for (Comment comment : comments) {
                System.out.println("- Comment by " + comment.getAuthor() + ": " + comment.getText());
            }
        }

        System.out.println("\nTesting deletion:");
        if (postService.deletePost(1, "User1")) {
            System.out.println("Post 1 deleted successfully by User1");
        } else {
            System.out.println("Failed to delete Post 1 (wrong author or post not found)");
        }
    }
}