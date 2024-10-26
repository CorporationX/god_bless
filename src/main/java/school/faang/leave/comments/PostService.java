package school.faang.leave.comments;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PostService {
    private final ConcurrentMap<Integer, Post> posts = new ConcurrentHashMap<>();

    public void addPost(Post post) {
        posts.put(post.getId(), post);
        System.out.println("Добавили пост " + post);
    }

    public void addComment(int postId, Comment comment) {
        posts.get(postId).addComment(comment);
        System.out.println("Добавили коммент " + comment + " к посту " + posts.get(postId));
    }

    public List<Comment> getComments(int postId) {
        return posts.get(postId).getComments();
    }

    public List<Post> getPosts() {
        return posts.values().stream().toList();
    }

    public Post getPost(int postId) {
        return posts.get(postId);
    }

    public List<Post> getPosts(String content) {
        return posts.values().stream()
                .filter(post -> post.containsContent(content))
                .toList();
    }

    public void removeComment(int postId, int commentId, String initiator) {
        posts.get(postId).removeComment(commentId, initiator);
    }

    public void removePost(int postId, String initiator) {
        Post post = posts.get(postId);
        validatePost(initiator, post);
        posts.remove(postId);
    }

    private void validatePost(String initiator, Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Данный пост не существует");
        }
        if (!post.isPostAuthor(initiator)) {
            throw new IllegalArgumentException("Пользователь не является автором поста");
        }
    }
}
