package faang.school.godbless.secondSprint.RecommenderSystem;

import java.time.LocalDate;

public record ProductOrder(int userId, int productId, LocalDate orderDate) {
}
