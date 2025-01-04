package derschrank.sprint04.task15.bjstwo_51173;

public interface PostServiceInterface {
    void addPost(Post post);

    void removePost(int postId, Author author);

    void addComment(int postId, Comment comment);

    void removeComment(int postId, Comment comment, Author author);
}
