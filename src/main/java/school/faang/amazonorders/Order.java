package school.faang.amazonorders;

import lombok.Data;

import java.util.UUID;

@Data
public class Order {
    private final UUID id = UUID.randomUUID();
    private String status = "In progress";
}
