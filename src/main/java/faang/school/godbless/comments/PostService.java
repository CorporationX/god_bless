package faang.school.godbless.comments;

import lombok.Getter;

import java.util.HashMap;
import java.util.Optional;

@Getter
public class PostService {
    private volatile HashMap<Integer, Post> posts = new HashMap<>();
    private final Object LOCKPOSTS = new Object();

    public void addComment(int index, Comment comment) {
        if (posts.containsKey(index)) {
            synchronized (LOCKPOSTS) {
                posts.get(index).addComment(comment);
            }
        } else {
            throw new IllegalArgumentException("There is no post with this id!");
        }
    }

    public Optional<Post> getPostById(int id){
        return Optional.ofNullable(posts.get(id));
    }

    public void addPost(Post post) {
        synchronized (LOCKPOSTS) {
            if (!posts.containsKey(post.getId())) {
                posts.put(post.getId(), post);
            } else {
                throw new IllegalArgumentException("Such id post already exists!");
            }
        }
    }

    public void deletePost(int id, String author) {
        if (posts.containsKey(id)){
            synchronized (LOCKPOSTS) {
                if (author.equals(posts.get(id).getAuthor())) {
                    posts.remove(id);
                } else {
                    throw new IllegalArgumentException("You are not an author!");
                }
            }
        }
    }

    public void deleteComment(int id, Comment comment, String author) {
        if (posts.containsKey(id)){
            synchronized (LOCKPOSTS) {
                if (comment.getAuthor().equals(author)) {
                    posts.get(id).deleteComment(comment);
                } else {
                    throw new IllegalArgumentException("You are not an author!");
                }
            }
        }
    }

    public void viewComments(int id) {
        if (posts.containsKey(id)) {
            posts.get(id).getComments().stream().forEach(comment -> {
                System.out.printf("%s on %d wrote: %s", comment.getAuthor(), comment.getTime(), comment.getText());
                System.out.println();
            });
        }
    }
}
