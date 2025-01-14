package school.faang.task_51495;

public class FacebookCommentSystem {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Runnable user1 = () -> {
            Post post = new Post(1, "First Post", "This is the content of the first post.", "User1");
            postService.addPost(post);
            postService.addComment(1, new Comment("Great post!", "User2"));
            postService.addComment(1, new Comment("Thanks for sharing!", "User3"));
        };

        Runnable user2 = () -> {
            postService.addComment(1, new Comment("Interesting thoughts!", "User4"));
            postService.removeComment(1, "User3", "User3");
            postService.removePost(1, "User1");
        };

        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        postService.getPosts().forEach(post -> {
            System.out.println("Post: " + post.getTitle() + ", Comments: " + post.getComments().size());
        });
    }
}