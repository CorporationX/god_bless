package faang.school.godbless.double_cache_cache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Subject {
    private UUID id;
    private String name;
}
