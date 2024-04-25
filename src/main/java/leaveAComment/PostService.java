package leaveAComment;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(int id, Comment comment) {
        synchronized (posts.get(id)) {
            posts.get(id).getComments().add(comment);
        }
    }

    public synchronized void addPost(Post post) {
        if (post == null) {
            throw new NullPointerException("Post must be exist");
        }
        posts.add(post);
    }

    public void lookPosts() {
        new ArrayList<>(posts).forEach(this::printPost);
    }

    public void lookPostAndComments(Post post) {
        new ArrayList<>(posts).stream()
                .filter(post1 -> post1.equals(post))
                .forEach(post1 -> {
                    printPost(post);
                    printComment(post);
                });
    }

    public void removePost(Author author) {
        posts.removeIf(post -> post.getAuthor().equals(author));
    }

    private void printPost(Post post) {
        System.out.printf("\n%s" +
                "\n%s" +
                "\n%s\n", post.getHeader().toUpperCase(), post.getText(), post.getAuthor());
    }

    private void printComment(Post post) {
        System.out.println("===Comments===");
        post.getComments().forEach(comment -> System.out.printf("%s" +
                "\n%s %s\n\n", comment.getContent(), comment.getAuthor(), comment.getDate()));
        System.out.println("===End Comments===");
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

}
