package faang.school.godbless.alexbulgakoff.collectionstreamapioptional.recomendationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductOrder {
    private int userId;
    private int productId;
    private Date orderDate;
}
