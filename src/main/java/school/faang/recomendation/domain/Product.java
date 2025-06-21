package school.faang.recomendation.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Data
@EqualsAndHashCode(of = "productId")
public class Product {

    private int productId;
    private String name;
    private String category;
    private double price;
    private List<String> tags;
}
