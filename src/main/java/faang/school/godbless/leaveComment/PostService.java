package faang.school.godbless.leaveComment;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private final ReentrantLock lockPostService = new ReentrantLock();

    public void addComment(Comment comment, int id) {
        posts.get(id).getLockPost().lock();
        posts.get(id).getComments().add(comment);
        System.out.println(comment.getText() + " added to " + posts.get(id).getTitle());
        posts.get(id).getLockPost().unlock();
    }

    public void addPost(Post post) {
        lockPostService.lock();
        posts.add(post);
        System.out.println(post.getTitle() + " added");
        lockPostService.unlock();
    }

    public List<Comment> getPostsComments(int idPost) {
        return posts.get(idPost).getComments();
    }

    public void refactorComment(int idPost, String authorOfComment, String commentOldText, String newText) {
        Comment requiredComment = findComment(idPost, authorOfComment, commentOldText);
        int idOfOldComment = posts.get(idPost).getComments().indexOf(requiredComment);
        posts.get(idPost).getComments().set(idOfOldComment,
                new Comment(newText, requiredComment.getDateTime(), authorOfComment));
        System.out.println("Post was changed");
    }

    public void removeComment(int idPost, String authorOfComment, String commentText){
        posts.get(idPost).getComments().remove(findComment(idPost, authorOfComment, commentText));
        System.out.println("Post was removed");
    }

    private Comment findComment(int idPost, String authorOfComment, String commentText){
        return posts.get(idPost).getComments().stream()
                .filter(comment -> comment.getAuthor().equals(authorOfComment))
                .filter(comment -> comment.getText().equals(commentText))
                .toList().get(0);
    }

}
