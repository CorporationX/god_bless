package school.faang.volatile_immutable_classes_deadlock_concurrency.bjs2_93619;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final InMemoryDataBase<Integer, Post> db = new InMemoryDataBase<>();

    public boolean addPost(@NonNull Post post) {
        Integer postId = post.getId();
        boolean added = db.putIfAbsent(postId, post);
        if (!added) {
            log.info("Пост с таким id: {} не добавлен, так как уже существует", postId);
        }
        return added;
    }

    public int getCountPosts() {
        return db.size();
    }

    public Post getPost(int idPost) {
        return db.get(idPost);
    }

    public List<Integer> getKeys() {
        return db.getKeys();
    }

    public boolean addComment(int postId, @NonNull Comment comment) {
        boolean added = db.updateByValueIf(postId, (post) -> {
            post.addComment(comment);
            return post;
        });

        if (!added) {
            log.info("Поста с таким id: {} не существует", postId);
        }
        return added;
    }

    public boolean removePost(int postId) {
        return db.removeById(postId);
    }

    public boolean removeAllUserCommentsInPost(int postId, User user) {
        return db.updateByValueIf(postId, post -> {
            post.removeComment((comment) -> comment.author().id() == user.id());
            return post;
        });
    }
}