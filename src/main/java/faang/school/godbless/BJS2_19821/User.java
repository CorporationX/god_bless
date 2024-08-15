package faang.school.godbless.BJS2_19821;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {
    private final Long id;
    @Getter
    private String name;
}
