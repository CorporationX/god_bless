package school.faang.task_47256.model;

import java.util.List;

public record Product(int productId,
                      String name,
                      String category,
                      double price,
                      List<String> tags) {
}
