package faang.school.godbless.comment;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        new Thread(() -> postService.addPost(new Post(1, "First Post", "This is the first post", "user1"))).start();
        new Thread(() -> postService.addPost(new Post(2, "Second Post", "This is the second post", "user2"))).start();

        new Thread(() -> postService.addComment(1, new Comment("Nice post!", LocalDateTime.now(), "user3"))).start();
        new Thread(() -> postService.addComment(1, new Comment("Thanks for sharing.",  LocalDateTime.now(), "user4"))).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Post post : postService.getPosts()) {
            System.out.println("Post: " + post.getTitle() + " by " + post.getAuthor());
            for (Comment comment : post.getComments()) {
                System.out.println("Comment: " + comment.getText() + " by " + comment.getAuthor());
            }
        }
    }
}
