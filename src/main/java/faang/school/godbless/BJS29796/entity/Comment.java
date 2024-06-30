package faang.school.godbless.BJS29796.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Comment {

    private Integer id;
    private String text;
    private User user;

    public Comment(String text, User user) {
        this.text = text;
        this.user = user;
    }
}
