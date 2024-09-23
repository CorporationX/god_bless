package ru.kraiush.threads.BJS2_25570;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private List<Product> listProducts;

    public BigDecimal getTotalPrice(List<Product> listProducts) {
        return listProducts.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal applyDiscount(BigDecimal totalPrice, PromoCode ortderPromoCode) {
        BigDecimal discont = (BigDecimal.valueOf(ortderPromoCode.getDiscount()).multiply(totalPrice)).divide(new BigDecimal(100));
        return totalPrice.subtract(discont);
    }
}
