package faang.school.godbless.alexbulgakoff.collectionstreamapioptional.recomendationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int productId;
    private String name;
    private String category;
    private BigDecimal price;
    private UserProfile user;
    private List<String> tags = user.getInterests();
}
