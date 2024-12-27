package school.faang.task_51193;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class User {
    private final UUID id = UUID.randomUUID();
    private final String name;
}
