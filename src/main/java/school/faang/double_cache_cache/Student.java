package school.faang.double_cache_cache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Objects;

@EqualsAndHashCode
@Getter
@ToString
@AllArgsConstructor
public class Student {
    @NonNull   private String name;
}
