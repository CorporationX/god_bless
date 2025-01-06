package school.faang.bjs251159;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Post {
    private final int id;
    private final String author;
    private final String title;
    private final String content;
    private final List<Comment> comments = new ArrayList<>();
}