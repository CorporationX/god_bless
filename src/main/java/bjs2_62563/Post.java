package bjs2_62563;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@RequiredArgsConstructor
public class Post {
    private final int id;
    @NonNull
    private final String title;
    @NonNull
    private final String content;
    @NonNull
    private final String author;
    private final List<Comment> comments = new CopyOnWriteArrayList<>();
}
