package school.faang;

import java.util.List;

public record Product(int productId, String name, String category, double price, List<String> tags) {
}
