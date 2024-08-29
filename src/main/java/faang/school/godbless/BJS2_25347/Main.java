package faang.school.godbless.BJS2_25347;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int NUMS_POSTS = 10;
        final int NUMS_COMMENTS = 100;

        PostService postService = new PostService();
        List<Author> authors = createAuthors(20);
        List<Post> posts = postService.getPosts();
        Random random = new Random();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < NUMS_POSTS; i++) {
            int id = i;
            String title = "Title_" + i;
            String content = "Content_" + i;
            Author author = authors.get(random.nextInt(authors.size()));
            executor.execute(() -> {
                postService.addPost(new Post(id, title, content, author));
//                sleep(10000);
            });

        }
        sleep(2000);
        for (int i = 0; i < NUMS_COMMENTS; i++) {
            int id =i;
            String text = "SomeComment_" + i;
            LocalDateTime date = LocalDateTime.now();
            Author author = authors.get(random.nextInt(authors.size()));
            Post post = posts.get(random.nextInt(posts.size()));
            executor.execute(() -> {
                postService.addComment(new Comment(id, text, date, author, post));
//                sleep(10000);
            });
        }

        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
//        postService.getPosts().forEach(System.out::println);
//        postService.getPosts().stream()
//                .flatMap(post -> post.getComments().stream())
//                .forEach(System.out::println);
        System.out.println("View post:");
        System.out.println(postService.getPost(random.nextInt(posts.size())));
        System.out.println("Remove post:");
        int id = posts.get(random.nextInt(posts.size())).getId();
        postService.removePost(id,posts.get(id).getAuthor());
        System.out.println("Remove not our post:");
        postService.removePost(id,posts.get(id+1).getAuthor());
    }

    public static List<Author> createAuthors(int count) {
        return IntStream.range(1, count)
                .mapToObj(i -> new Author(i, "Author_" + i))
                .toList();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
