package school.faang.commentator;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class PostService {
    private List<Post> posts = new CopyOnWriteArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addComment(int postId, Comment comment) {
        Optional<Post> post = posts.stream()
                .filter(p -> p.getId() == postId)
                .findFirst();
        post.ifPresent(p ->  p.addComment(comment));
    }

    public void printPosts() {
        posts.forEach(post -> log.info("{}.\n{}:\n{}\n", post.getAuthor(), post.getTitle(), post.getContent()));
    }

    public void printComment(Post post) {
        post.getComments().forEach(comment -> log.info("{}.\n{}.\n{}\n",
                comment.getAuthor(), comment.getText(), comment.getTimestamp()));
    }

    public void deletePost(Post post) {
        if (!posts.remove(post)) {
            log.info("Такого поста не существует.");
        }
    }

    public void deleteComment(Post post, Comment comment) {
        if (!post.getComments().remove(comment)) {
            log.info("Такого комментария не существует.");
        }
    }
}
