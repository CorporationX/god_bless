package school.faang.theirontroneatanycost;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Getter
public class Role {
    @EqualsAndHashCode.Include
    private final int id;
    private String name;
}
