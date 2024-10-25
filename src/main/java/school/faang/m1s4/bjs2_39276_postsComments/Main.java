package school.faang.m1s4.bjs2_39276_postsComments;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        PostService postService = new PostService();

        List<String> users = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "Doug", "Elon"));

        for (int i = 0; i < 30; i++) {
            Post post = new Post("Content" + i, users.get(random.nextInt(users.size())), "Title " + i);
            Comment comment = new Comment("Comment text " + i, users.get(random.nextInt(users.size())));
            postService.addPost(post);
            postService.addComment(random.nextInt(i + 1), comment);
        }

        postService.showPosts();

        sleep(5000);

        System.out.println();

        postService.showComments(1);

        sleep(1000);

        postService.addPost(new Post("Whatever", "Zuker", "Bullshit"));
        postService.addComment(31, new Comment("LOSER!!", "Musk"));

        sleep(1000);

        postService.removeComment(31, 31, "Musk");
        postService.removePost(31, "Zuker");
        postService.removePost(1, "Alice");

        sleep(3000);

        postService.showPosts();

        postService.shutdownPool();

    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}
