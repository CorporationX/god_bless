package faang.school.godbless.BJS2_24364;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class User {
    @EqualsAndHashCode.Include
    @ToString.Include
    private final String name;
    private boolean isOnline;
}
