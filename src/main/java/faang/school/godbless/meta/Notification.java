package faang.school.godbless.meta;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Notification {
    private String type;
    private String message;

}
