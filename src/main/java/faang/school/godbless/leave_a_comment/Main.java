package faang.school.godbless.leave_a_comment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        Thread tomThread = new Thread(() -> postService.addPost(new Post("Post 1", "Отдых с друзьями", "Tom")));
        Thread bobThread = new Thread(() -> postService.addPost(new Post("Post 2", "Рабочий понедельник", "Bob")));
        tomThread.start();
        bobThread.start();

        Thread annComment = new Thread(() -> postService.addComment(1,
                new Comment("Еду к вам", "Ann", "12:26 22/11/2006")));
        Thread markComment = new Thread(() -> postService.addComment(2,
                new Comment("Понимаю тебя бро(", "Mark", "21:03 13/06/2007")));
        annComment.start();
        markComment.start();

        try {
            tomThread.join();
            bobThread.join();
            annComment.join();
            markComment.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Post> allPost = postService.getPosts();
        for (Post post : allPost) {
            System.out.println("Пост: " + post.getText() + ", Автор: " + post.getAuthor());
            List<Comment> comments = post.getComments();
            for (Comment comment : comments) {
                System.out.println("Комментарий: " + comment.getText() + ", Автор: " + comment.getAuthor());
            }
        }
    }
}
