package ru.kraiush.threads.BJS2_25625;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class AppWeLeaveComments_in_Facebook {

    public static void main(String[] args) throws InterruptedException {

        List<Post> posts = new ArrayList<>();
        System.out.print(String.join("", Collections.nCopies(120, "-")));
        System.out.println();
        Post post1 = new Post(1, "Wild world", "Dangerous predators", new Author(getAuthor()));
        Post post2 = new Post(2, "Be healthy", "Do morning exercises", new Author(getAuthor()));
        Post post3 = new Post(3, "The Golden Key", "The tale of Pinocchio", new Author("Alexey Tolstoy"));

        List<PostService> listPosts = new ArrayList<>();
        listPosts.add(new PostService(posts, post1, null));
        listPosts.add(new PostService(posts, post2, null));
        listPosts.add(new PostService(posts, post3, null));
        for (PostService listPost : listPosts) {
            listPost.start();
        }

        Comment comm1 = new Comment(ThreadLocalRandom.current().nextInt(1, posts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm2 = new Comment(ThreadLocalRandom.current().nextInt(1, posts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm3 = new Comment(ThreadLocalRandom.current().nextInt(1, posts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm4 = new Comment(ThreadLocalRandom.current().nextInt(1, posts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));
        Comment comm5 = new Comment(ThreadLocalRandom.current().nextInt(1, posts.size() + 1), getCommentText(), new Date(), new Author(getAuthor()));

        List<PostService> listComments = new ArrayList<>();

        listComments.add(new PostService(posts, null, comm1));
        listComments.add(new PostService(posts, null, comm2));
        listComments.add(new PostService(posts, null, comm3));
        listComments.add(new PostService(posts, null, comm4));
        listComments.add(new PostService(posts, null, comm5));

        for (PostService listComment : listComments) {
            listComment.start();
        }
        posts.forEach(System.out::println);
        System.out.print(String.join("", Collections.nCopies(120, "-")));
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
