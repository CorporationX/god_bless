package faang.school.godbless.FourthSprint.bjs2_51333;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Getter
@ToString
public class Post {
    private final Integer id;
    private final String title;
    private final String content;
    private final User author;
    private final List<Comment> comments = new ArrayList<>();
}
