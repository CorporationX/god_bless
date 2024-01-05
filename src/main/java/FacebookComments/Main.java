package FacebookComments;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();

        ExecutorService commentExecutorService = Executors.newFixedThreadPool(50);
        ExecutorService postExecutorService = Executors.newFixedThreadPool(50);

        int numberOfPosts = 5;
        int numberOfComments = 50;

        //добавляем посты
        for (int i = 0; i < numberOfPosts; i++) {
            int randomInt = i;
            postExecutorService.submit(() -> postService.addPost(
                    new Post("Name" + randomInt, "Text" + randomInt, "Author")));
        }
        //добавляем комментарии
        for (int i = 0; i < numberOfComments; i++) {
            int randomInt = i;
            commentExecutorService.submit(() -> postService.addComment(
                    (int) (Math.random() * numberOfPosts), new Comment("Text" + randomInt, "Author")));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //Просматриваем пост/комментарий
            postExecutorService.submit(() -> postService.showPost((int) (Math.random() * numberOfPosts)));
            commentExecutorService.submit(() -> postService.showComment((int) (Math.random() * numberOfPosts), randomInt));

        }

        //Удаляем пост/комментарий
        // Удаляем по индексам в обратном порядке, чтобы не нарушить последовательность
        for (int i = numberOfPosts - 1; i >= 0; i--) {
            int randomInt = i;
            //Т.к. постов мало то удаляются они быстро и комментариев для удаления почти не остается
            //Для проверки корректности удаления комментариев можно закомментировать строку с удалением постов
            postExecutorService.submit(() -> postService.deletePost((int) (Math.random()*numberOfPosts), "Author"));
            commentExecutorService.submit(() -> postService.deleteComment((int) (Math.random() * numberOfPosts), randomInt, "Author"));
        }


        commentExecutorService.shutdown();
        postExecutorService.shutdown();
        System.out.println(postService.getPosts());
    }
}
