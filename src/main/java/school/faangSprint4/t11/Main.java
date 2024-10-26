package school.faangSprint4.t11;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        UserAction[] actions = {
                new UserAction.Builder()
                        .setPost(new Post(1, "First Post", "Content 1", "User1"))
                        .setCommentToPostId(1)
                        .setComment(new Comment("Great post!", "User2"))
                        .setDelay(100)
                        .build(),

                new UserAction.Builder()
                        .setPost(new Post(2, "Second Post", "Content 2", "User2"))
                        .setCommentToPostId(1)
                        .setComment(new Comment("Nice content!", "User1"))
                        .setDelay(50)
                        .build(),

                new UserAction.Builder()
                        .setCommentToPostId(2)
                        .setComment(new Comment("Interesting!", "User3"))
                        .setDelay(150)
                        .build()
        };

        Thread[] threads = new Thread[actions.length];
        for (int i = 0; i < actions.length; i++) {
            UserAction action = actions[i];
            threads[i] = new Thread(() -> executeUserAction(postService, action));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    private static void executeUserAction(PostService postService, UserAction action) {
        try {
            if (action.getPost() != null) {
                postService.addPost(action.getPost());
            }

            if (action.getDelay() > 0) {
                Thread.sleep(action.getDelay());
            }

            if (action.getComment() != null && action.getCommentToPostId() > 0) {
                postService.addComment(action.getCommentToPostId(), action.getComment());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}