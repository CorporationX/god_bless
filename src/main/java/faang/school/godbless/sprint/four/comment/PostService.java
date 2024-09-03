package faang.school.godbless.sprint.four.comment;

import lombok.Getter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class PostService {
    private volatile List<Post> posts = new CopyOnWriteArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
        System.out.printf("Post %s added%n", post.getTitle());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addComment(int postId, Comment comment) {
        Post post = findPostById(postId);
        post.addComment(comment);
        System.out.printf("Comment '%s' will be added to the post %s%n", comment.getText(), post.getTitle());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeComment(int commentId, long userId) {
        Post post = findPostByCommentId(commentId);
        post.removeComment(commentId, userId);
        System.out.printf("CommentId '%d' will be removed from the post %s%n", commentId, post.getTitle());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getRandomPost() {
        Random random = new Random();
        return random.nextInt(posts.size()) + 1;
    }

    private Post findPostByCommentId(int commentId) {
        return posts.stream()
                .filter(post -> post.getComments()
                        .stream()
                        .anyMatch(comment -> comment.getId() == commentId)
                )
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException(String.format("Post with Comment ID %d not found%n", commentId))
                );
    }

    private Post findPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Post with ID %d not found%n", postId)));
    }
}
