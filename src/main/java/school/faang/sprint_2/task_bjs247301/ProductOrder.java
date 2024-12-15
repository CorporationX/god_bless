package school.faang.sprint_2.task_bjs247301;

import lombok.NonNull;

public record ProductOrder(
        int userId,
        int productId,
        @NonNull String orderDate) {}
