package school.faang.bjs2_80767_recom_system;

import java.util.Set;

public record Product(int productId, String name, String category, double price, Set<String> tags) {
}
