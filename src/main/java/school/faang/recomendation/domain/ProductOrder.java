package school.faang.recomendation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Data
public class ProductOrder {

    private int userId;
    private int productId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;
}
