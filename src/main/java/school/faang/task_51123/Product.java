package school.faang.task_51123;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Product {
    private final UUID productId = UUID.randomUUID();
    private final String name;
    private final double price;
}
