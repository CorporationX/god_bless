package school.faang.task_51573;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Donation {
    private final UUID id = UUID.randomUUID();
    private final double amount;
}
