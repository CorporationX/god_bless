package ru.kraiush.threads.BJS2_25625;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppWeLeaveComments_in_Facebook {

    public static void main(String[] args) throws InterruptedException {

        final CopyOnWriteArrayList<Post> listPosts = new CopyOnWriteArrayList<>();
        final List<PostService> listPostServices = new ArrayList<>();
        final Lock lock = new ReentrantLock();
        ExecutorService THREAD_POOL = Executors.newFixedThreadPool(8);

        Post post1 = new Post(1, "Wild world", "Dangerous predators", new Author(getAuthor()));
        Post post2 = new Post(2, "Be healthy", "Do morning exercises", new Author(getAuthor()));
        Post post3 = new Post(3, "The Golden Key", "The tale of Pinocchio", new Author("Alexey Tolstoy"));

        listPostServices.add(new PostService(listPosts, post1, null, lock));
        listPostServices.add(new PostService(listPosts, post2, null, lock));
        listPostServices.add(new PostService(listPosts, post3, null, lock));

        for (PostService post : listPostServices) {
            THREAD_POOL.execute(post);
        }
        Thread.sleep(1000);

        System.out.print(String.join("", Collections.nCopies(175, "-")));
        System.out.println("\nPosts without comments");
        listPosts.forEach(System.out::println);

        Comment comm1 = new Comment(new Random().nextInt(1, listPosts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm2 = new Comment(new Random().nextInt(1, listPosts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm3 = new Comment(new Random().nextInt(1, listPosts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm4 = new Comment(new Random().nextInt(1, listPosts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm5 = new Comment(new Random().nextInt(1, listPosts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));

        List<PostService> listComments = new ArrayList<>();

        listComments.add(new PostService(listPosts, null, comm1, lock));
        listComments.add(new PostService(listPosts, null, comm2, lock));
        listComments.add(new PostService(listPosts, null, comm3, lock));
        listComments.add(new PostService(listPosts, null, comm4, lock));
        listComments.add(new PostService(listPosts, null, comm5, lock));

        for (PostService comment : listComments) {
            THREAD_POOL.execute(comment);
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        THREAD_POOL.shutdown();

        System.out.println("\nPosts with comments");
        listPosts.forEach(System.out::println);
        System.out.print(String.join("", Collections.nCopies(175, "-")));
    }

    public static String getAuthor() {
        String[] memberNames = {"Apollo", "Sharon", "Maggie", "Lewis", "Steve", "Bridget", "Jessica", "Om", "John", "Elvis"};
        return memberNames[new Random().nextInt(memberNames.length)];
    }
    public static String getCommentText() {
        String[] memberNames = {"Complete nonsense", "Perfectly", "It sucks", "Fuck you thouts", "It's inimitable", "Abra Cada Bra", "It is very useful and informative"};
        return memberNames[new Random().nextInt(memberNames.length)];
    }
}
