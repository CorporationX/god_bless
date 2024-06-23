package faang.school.godbless.matters_of_the_heart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class User {
    private String name;
    private boolean isOnline;
}
