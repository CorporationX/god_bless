package faang.school.godbless.bjs225556;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Post {
    private final int id;
    private final String header;
    private final String text;
    private final User user;
    private List<Comment> comments = new ArrayList<>();
}
