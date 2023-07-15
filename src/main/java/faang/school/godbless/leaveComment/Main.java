package faang.school.godbless.leaveComment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Post post1 = new Post(1, "Text 1", "Author 1", "Title 1");
        Post post2 = new Post(2, "Text 2", "Author 2", "Title 2");
        Comment comment1 = new Comment("Comment 1", "Author 1");
        Comment comment2 = new Comment("Comment 2", "Author 2");

        Thread thread1 = new Thread(() -> {
            postService.addPost(post1);
            postService.addComment(post1.getId(), comment1);
        });

        Thread thread2 = new Thread(() -> {
            postService.addPost(post2);
            postService.addComment(post2.getId(), comment1);
            postService.addComment(post2.getId(), comment2);
        });

        Thread thread3 = new Thread(() -> {
            postService.deleteComment(post2.getId(), comment1);
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Post> posts = postService.getPosts();
        for (Post post : posts) {
            System.out.println("Post: " + post.getTitle());
            System.out.println("Author: " + post.getAuthor());
            System.out.println("Text: " + post.getText());
            System.out.println("Comments:");
            List<Comment> comments = post.getComments();
            for (Comment comment : comments) {
                System.out.println("- " + comment.getAuthor() + ": " + comment.getTextComment());
            }
            System.out.println();
        }
    }

}
