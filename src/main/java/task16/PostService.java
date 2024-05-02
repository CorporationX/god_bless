package task16;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
public class PostService {
    private volatile List<Post> posts;

    public synchronized void addComment(Comment comment, Long postId) {
        Optional<Post> postOptional = posts.stream().filter(post -> post.getId().equals(postId)).findFirst();
        postOptional.ifPresent(post -> post.addComment(comment));
    }

    public synchronized void addPost(Post post) {
        posts.add(post);
    }

}