package faang.school.godbless.BJS2_25322;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
public class Post {
    private final long id;
    private final String title;
    private final String text;
    private final String author;
    @ToString.Exclude
    private final List<Comment> comments = new ArrayList<>();
}
