package school.faang.sprint4.bjs251242;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Thread postPublication1 =
                createPostThread(1, "Hello everyone", "It's my first post", "Anna", postService);
        Thread postPublication2 =
                createPostThread(2, "Wether is nice", "Sharing with you...", "Bob", postService);

        postPublication1.start();
        postPublication2.start();
        try {
            postPublication1.join();
            postPublication2.join();
        } catch (InterruptedException e) {
            log.error("Error when publishing a post: {}", e.getMessage());
        }

        Thread commentPublication1 = createCommentThread("Oh... good", "Lana", 2, postService);
        Thread commentPublication2 = createCommentThread("Hi, choco", "Bob", 1, postService);

        commentPublication1.start();
        commentPublication2.start();
        try {
            commentPublication1.join();
            commentPublication2.join();
        } catch (InterruptedException e) {
            log.error("Error when publishing a comment: {}", e.getMessage());
        }

        Thread postDeletion = new Thread(() -> {
            boolean isDeletedPost = postService.deletePost(1, "Anna");
            log.info("Post with ID 1 deleted: {}", isDeletedPost);
        });

        Thread commentDeletion = new Thread(() -> {
            Comment commentDelete = new Comment("Oh... good", "Lana");
            boolean isDeletedComment = postService.deleteComment(2, commentDelete, "Karl");
            log.info("Comment {}, deleted: {}", commentDelete, isDeletedComment);
        });

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

    private static Thread createPostThread(int id, String title, String content, String author, PostService postServ) {
        return new Thread(() -> {
            Post post = new Post(id, title, content, author);
            postServ.addPost(post);
            log.info("Post added with {}", post);
        });
    }

    private static Thread createCommentThread(String text, String author, int postId, PostService postService) {
        return new Thread(() -> {
            Comment comment = new Comment(text, author);
            postService.addComment(postId, comment);
            log.info("Comment added {}", comment);
        });
    }
}