package school.faang.bjs2_75935;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@AllArgsConstructor
public class Post {
    private final int id; //уникальный идентификатор поста
    private final String title;//заголовок поста
    private final String content;//текст поста
    private final Author author; //автор поста
    private final List<Comment> comments = new ArrayList<>(); //список комментариев (List<Comment>).
    private final ReentrantLock lock = new ReentrantLock();

    public void addComment(Comment)
}
