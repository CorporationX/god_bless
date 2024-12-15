package school.faang.sprint_2.task_bjs247301;

import lombok.NonNull;

import java.util.List;

public record Product(
        int productId,
        @NonNull String name,
        @NonNull String category,
        double price,
        @NonNull List<String> tags) {}
