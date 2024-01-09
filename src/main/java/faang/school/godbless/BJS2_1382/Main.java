package faang.school.godbless.BJS2_1382;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        User user1 = new User("Edisolt");
        User user2 = new User("Inna Mishustina");

        Post post1 = new Post("Java Bootcamp", "What do I think it was like", user1, new ArrayList<>());
        Post post2 = new Post("Java Bootcamp", "I hate students", user2, new ArrayList<>());

        postService.addPost(post1);
        postService.addPost(post2);

        Comment comment1 = new Comment("I hate u", user2);
        Comment comment2 = new Comment("We respect u", user1);

        postService.addComment(post2, comment1);
        postService.addComment(post1, comment2);

    }
}