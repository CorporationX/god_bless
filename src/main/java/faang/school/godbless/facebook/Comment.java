package faang.school.godbless.facebook;

import lombok.Getter;

import java.util.Date;

@Getter
public class Comment {
    private final Long id;
    private final String text;
    private final Long timeCreate;

    public Comment(Long id, String text) {
        if (text == null) {
            throw new IllegalArgumentException("In constructor Comment class apply String text is null");
        }
        this.id = id;
        this.text = text;
        Date date = new Date();
        timeCreate = date.getTime();
    }
}
