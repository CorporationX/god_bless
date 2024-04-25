package faang.school.godbless.concurrency.comment;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();


    public synchronized void addComment(int postId, String commentText, String commentAuthor) {
        verifyPostId(postId);

        var postToAddComment = posts.get(postId);

        postToAddComment.comments().add(new Comment(commentText, LocalDateTime.now(), commentAuthor));

        log.info(commentAuthor + " added comment to post with id " + postId);
    }

    public synchronized void addPost(String postHeader, String postBody, String postAuthor) {
        var newPost = new Post(postHeader, postBody, postAuthor, new ArrayList<>());

        posts.add(newPost);

        log.info(postAuthor + " added new post");
    }

    public synchronized Post getPostById(int postId) {
        verifyPostId(postId);

        return posts.get(postId);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public synchronized List<Comment> getCommentsByPostId(int postId) {
        return getPostById(postId).comments();
    }

    public synchronized Comment getCommentById(int postId, int commentId) {
        verifyCommentId(postId, commentId);

        return getPostById(postId).comments().get(commentId);
    }

    public synchronized void removePostById(int postId, @NonNull String userName) throws IllegalAccessException {
        verifyPostId(postId);

        if(!getPostById(postId).author().equals(userName)) {
            throw new IllegalAccessException("Post can be deleted only by its author!");
        }

        posts.remove(postId);
    }

    public synchronized void removeCommentById(int postId, int commentId, @NonNull String userName) throws IllegalAccessException {
        verifyCommentId(postId, commentId);

        if(!getCommentById(postId, commentId).author().equals(userName)) {
            throw new IllegalAccessException("Comment can be deleted only by its author!");
        }

        getPostById(postId).comments().remove(commentId);
    }


    private void verifyPostId(int postId) {
        if (postId >= posts.size() || postId < 0) {
            throw new NoSuchElementException("There is no such post with id = " + postId);
        }
    }

    private void verifyCommentId(int postId, int commentId) {
        var post = getPostById(postId);

        if (commentId >= post.comments().size() || commentId < 0) {
            throw new NoSuchElementException("There is no such comment with id = " + commentId + " in comments list of post with id " + postId);
        }
    }
}
