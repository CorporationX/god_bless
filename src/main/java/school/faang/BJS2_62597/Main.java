package school.faang.BJS2_62597;

public class Main {

    public static void main(String[] args) {
        PostService postService = new PostService();

        Runnable postTask = () -> {
            Post post = new Post(1, "My first post", "This is the content", "User1");
            postService.addPost(post);
            System.out.println("Post added: " + post.getTitle());
        };

        Runnable commentTask = () -> {
            Post post = new Post(2, "Another post", "Some content", "User2");
            postService.addPost(post);
            Comment comment = new Comment("Nice post!", "User3");
            postService.addComment(post.getId(), comment);
            System.out.println("Comment added by " + comment.getAuthor());
        };

        Thread postThread1 = new Thread(postTask);
        Thread postThread2 = new Thread(postTask);
        Thread commentThread1 = new Thread(commentTask);

        postThread1.start();
        postThread2.start();
        commentThread1.start();

        try {
            postThread1.join();
            postThread2.join();
            commentThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
