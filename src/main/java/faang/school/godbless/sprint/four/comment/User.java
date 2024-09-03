package faang.school.godbless.sprint.four.comment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private final long id;
    private final String name;
    private List<Comment> comments;
    private List<Integer> idsForDelete;

}
