package school.faang.sprint4.bjs251242;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Thread postPublication1 = new Thread(() -> {
            Post post1 = new Post(1, "Hello everyone", "It is my first post!", "Anna");
            postService.addPost(post1);
            log.info("Post added with {}", post1);
        });

        Thread postPublication2 = new Thread(() -> {
            Post post2 = new Post(2, "Wether is nice", "Sharing with you...", "Bob");
            postService.addPost(post2);
            log.info("Post added with {}", post2);
        });

        Thread commentPublication1 = new Thread(() -> {
            Comment comment1 = new Comment("Oh... good", "Lana");
            postService.addComment(2, comment1);
            log.info("Comment added {}", comment1);
        });

        Thread commentPublication2 = new Thread(() -> {
            Comment comment2 = new Comment("Hi, choco", "Bob");
            postService.addComment(1, comment2);
            log.info("Comment added {}", comment2);
        });

        Thread postDeletion = new Thread(() -> {
            boolean isDeletedPost = postService.deletePost(1, "Anna");
            log.info("Post with ID 1 deleted: {}", isDeletedPost);
        });

        Thread commentDeletion = new Thread(() -> {
            Comment commentDelete = new Comment("Oh... good", "Lana");
            boolean isDeletedComment = postService.deleteComment(2, commentDelete, "Karl");
            log.info("Comment {}, deleted: {}", commentDelete, isDeletedComment);
        });

        postPublication1.start();
        postPublication2.start();
        try {
            postPublication1.join();
            postPublication2.join();
        } catch (InterruptedException e) {
            log.error("Error when publishing a post: {}", e.getMessage());
        }

        commentPublication1.start();
        commentPublication2.start();
        try {
            commentPublication1.join();
            commentPublication2.join();
        } catch (InterruptedException e) {
            log.error("Error when publishing a comment: {}", e.getMessage());
        }

        commentDeletion.start();
        postDeletion.start();
        try {
            commentDeletion.join();
            postDeletion.join();
        } catch (InterruptedException e) {
            log.error("Error when deleting post or comment: {}", e.getMessage());
        }

        postService.getPosts().forEach(post -> {
            log.info("post {}", post);
            post.getComments().forEach(comment -> log.info("comment {}", comment));
        });
    }
}