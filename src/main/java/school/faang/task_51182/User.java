package school.faang.task_51182;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
@ToString
public class User {
    private final UUID id = UUID.randomUUID();
    private final String name;
}