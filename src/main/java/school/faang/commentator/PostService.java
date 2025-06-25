package school.faang.commentator;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class PostService {
    private List<Post> posts = new CopyOnWriteArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addComment(int postId, Comment comment) {
        for (Post post : posts) {
            if (post.getId() == postId) {
                post.getComments().add(comment);
                break;
            }
        }
    }

    public void printPosts() {
        posts.stream()
                .forEach(post -> log.info("{}.\n{}:\n{}\n", post.getAuthor(), post.getTitle(), post.getContent()));
    }

    public void printComment(Post post) {
        post.getComments().stream()
                .forEach(comment -> log.info("{}.\n{}.\n{}\n",
                        comment.getAuthor(), comment.getText(), comment.getTimestamp()));
    }

    public void deletePost(Post post) {
        posts.remove(post);
    }

    public void deleteComment(Post post, Comment comment) {
        post.getComments().remove(comment);
    }
}
