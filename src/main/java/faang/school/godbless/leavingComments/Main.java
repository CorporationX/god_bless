package faang.school.godbless.leavingComments;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();

        Thread thread1 = new Thread(
                () -> {
                    postService.addPost(new Post(0, "Content of 0 post", Thread.currentThread().getName()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    postService.addComment(new Comment(0, "Text of 0 comment", Thread.currentThread().getName()), 1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(postService.getPosts());
                    postService.deleteComment(1, 0);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(postService.getPosts());
                    postService.deletePost(0);
                });
        Thread thread2 = new Thread(
                () -> {
                    postService.addPost(new Post(1, "Content of 1 post", Thread.currentThread().getName()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    postService.addComment(new Comment(1, "Text of 1 comment", Thread.currentThread().getName()), 0);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(postService.getPosts());
                    postService.deleteComment(0, 1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(postService.getPosts());
                    postService.deletePost(1);
                });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(postService.getPosts());
    }
}
