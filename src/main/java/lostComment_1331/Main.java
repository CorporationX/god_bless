package lostComment_1331;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int COUNT_ADD_COMMENT = 30;

    public static void main(String[] args) {

        PostService postService = new PostService();

        for (int i = 1; i < 3; i++) {
            postService.addPost(new Post("POST_" + i, "text", "Author " + i, new ArrayList<>()));
        }

        ExecutorService service = Executors.newCachedThreadPool();
//Добавление комментариев через множество потоков
        for (int i = 1; i <= COUNT_ADD_COMMENT; i++) {
            int id = i;
            service.execute(() -> postService.addComment(postService.getPosts().get((int) (Math.random() * 2)), new Comment("Comment_" + id, "Author")));
        }
        service.shutdown();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boolean checkAddComment = postService.getPosts().get(0).getComments().size() + postService.getPosts().get(1).getComments().size() == COUNT_ADD_COMMENT;
        System.out.println("Все комментарии к постам добавлены - " + checkAddComment);

    }
}