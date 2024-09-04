package faang.school.godbless.comments;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostService {
    private final List<Post> posts;

    public PostService() {
        posts = new CopyOnWriteArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addComment(Comment comment, int id) {
        posts.stream()
                .filter(post1 -> post1.getId() == id)
                .findAny()
                .ifPresentOrElse(post1 -> post1.addComment(comment),
                        () -> {
                            throw new IllegalArgumentException("do not have post with id = " + id);
                        });
    }

    public void viewPostsWithComments() {
        for (Post post : posts) {
            System.out.printf("AUTHOR: %s\nTITLE: %s \n\tBODY: %s \n\tCOMMENTS:\n",
                    post.getAuthor(), post.getTitle(), post.getBody());
            for (Comment comment : post.getComments()) {
                System.out.printf("\t\tAUTHOR: %-20s BODY: %-20s\n",
                        comment.getAuthor(), comment.getBody());
            }
        }
    }

    public void deleteComment(Comment comment, int id) {
        String nameOfThread = Thread.currentThread().getName();
        if (comment.getAuthor().equals(nameOfThread)) {
            posts.stream()
                    .filter(post1 -> post1.getId() == id)
                    .findAny()
                    .ifPresentOrElse(post1 -> post1.deleteComment(comment),
                            () -> {
                                throw new IllegalArgumentException("do not have post with id = " + id);
                            });
        } else {
            System.out.println("you cant delete this comment");
        }
    }

    public void deletePost(int id) {
        posts.stream()
                .filter(post -> post.getAuthor().equals(Thread.currentThread().getName())
                && post.getId() == id)
                .findAny()
                .ifPresentOrElse(posts::remove,
                        () -> {
                            System.out.println("you cant delete this post");
                        });
    }
}
