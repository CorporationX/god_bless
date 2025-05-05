package leave.comments;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //Может задача и задумывалась как простая но я ВООБЩЕ НЕ ПОНЯЛ что от меня хотят,
        //и как это сделать красиво не натягивая сову на глобус так что как то так) желания что то менять тоже нет
        //Тут если делать как нужно по хорошему то уидет куча времени которого просто нет
        Author vasea = new Author("Vasea Pupkin");
        Author luke = new Author("Luke Skywalker");
        Comment comment1 = new Comment("Nice video!", luke, LocalDateTime.of(2025, 5, 3, 17, 14));
        Comment comment2 = new Comment("Bad video!", vasea, LocalDateTime.of(2025, 5, 3, 18, 14));
        Post carReview = new Post(1232, "Car review", "Today we review this porsche 911", vasea);
        Post xwingReview = new Post(6746, "X wing review", "Today we review this new X wing", luke);

        PostService postService = new PostService();

        final Thread thread1 = new Thread(() -> postService.addPost(carReview));
        final Thread thread2 = new Thread(() -> postService.addComment(carReview.getId(), comment1));
        final Thread thread3 = new Thread(() -> postService.addPost(xwingReview));
        final Thread thread4 = new Thread(() -> postService.addComment(xwingReview.getId(), comment2));
        final Thread thread5 = new Thread(() -> postService.readAllPosts());
        final Thread thread6 = new Thread(() -> postService.removePost(carReview.getId(), vasea));
        final Thread thread7 = new Thread(() -> postService.readAllPosts());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

    }
}
