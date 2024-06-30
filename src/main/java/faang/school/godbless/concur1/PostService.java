package faang.school.godbless.concur1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class PostService {
    private static final Object lock = new Object();
    private static final String MESSAGE_ERROR_DELETE_COMMENT = "У Вас нет прав на удаление чужого комментария";
    private static final String MESSAGE_ERROR_DELETE_POST = "У Вас нет прав на удаление чужого поста";
    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(int index, Comment comment) {
        synchronized (lock) {
            posts.get(index).comments().add(comment);
        }
    }

    public void addPost(Post post) {
        synchronized (lock) {
            posts.add(post);
        }
    }

    public void viewAllPosts() {
        posts.forEach(System.out::println);
    }

    public void deletePost(int postId, String nameUser) {
        synchronized (lock) {
            Post post = posts.get(postId);
            if (post.author().equals(nameUser)) {
                posts.remove(postId);
            } else {
                System.out.println(MESSAGE_ERROR_DELETE_POST);
            }
        }
    }

    public void deleteCommentFromPost(int postId, int commentId, String nameUser) {
        synchronized (lock) {
            Post post = posts.get(postId);
            Optional<Comment> commentForDelete = post.comments().stream()
                    .filter(comment -> comment.id() == commentId)
                    .findFirst();
            if (commentForDelete.isPresent()) {
                Comment comment = commentForDelete.get();
                if (comment.author().equals(nameUser)) {
                    post.comments().remove(commentId);
                } else {
                    System.out.println(MESSAGE_ERROR_DELETE_COMMENT);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
