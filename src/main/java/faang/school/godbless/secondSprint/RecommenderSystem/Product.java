package faang.school.godbless.secondSprint.RecommenderSystem;

import java.util.List;

public record Product(int productId, String name, String category, int price, List<String> tags) {
}
