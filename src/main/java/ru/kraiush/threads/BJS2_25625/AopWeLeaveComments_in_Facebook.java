package ru.kraiush.threads.BJS2_25625;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class AopWeLeaveComments_in_Facebook {

    public static void main(String[] args) {

        List<Post> posts = new ArrayList<>();
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();

        Post post1= new Post(0, "Wild world", "Dangerous predators", new Author(getAuthor()));
        Post post2= new Post(1, "Be healthy", "Do morning exercises", new Author(getAuthor()));
        Post post3= new Post(2, "The Golden Key", "The tale of Pinocchio", new Author("Alexey Tolstoy"));

        PostService service = new PostService(posts, post1, null);
        service.start();
        service = new PostService(posts, post2, null);
        service.start();
        service = new PostService(posts, post3, null);
        service.start();

        Comment comm1 = new Comment(ThreadLocalRandom.current().nextInt(0, posts.size()), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm2 = new Comment(ThreadLocalRandom.current().nextInt(0, posts.size()), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm3 = new Comment(ThreadLocalRandom.current().nextInt(0, posts.size()), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm4 = new Comment(ThreadLocalRandom.current().nextInt(0, posts.size()), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm5 = new Comment(ThreadLocalRandom.current().nextInt(0, posts.size()), getCommentText(), new Date(), new Author(getAuthor()));

        service = new PostService(posts, null, comm1);
        service.start();
        service = new PostService(posts, null, comm2);
        service.start();
        service = new PostService(posts, null, comm3);
        service.start();
        service = new PostService(posts, null, comm4);
        service.start();
        service = new PostService(posts, null, comm5);
        service.start();
        posts.forEach(System.out::println);
        System.out.print(String.join("", Collections.nCopies(80, "-")));
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
