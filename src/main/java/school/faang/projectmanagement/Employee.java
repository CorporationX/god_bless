package school.faang.projectmanagement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
    private final int id;
    @NonNull
    private final String name;
    private final Set<String> skills;
}
