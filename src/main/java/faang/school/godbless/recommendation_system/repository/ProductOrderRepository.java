package faang.school.godbless.recommendation_system.repository;

import faang.school.godbless.recommendation_system.model.ProductOrder;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderRepository {

    private final List<ProductOrder> PRODUCTS;

    public ProductOrderRepository() {
        this.PRODUCTS = new ArrayList<>();
    }

    public void addProductOrder(ProductOrder productOrder) {
        PRODUCTS.add(productOrder);
    }

    public List<ProductOrder> findAllProductOrders() {
        return PRODUCTS;
    }

    public List<ProductOrder> findProductOrdersByUserId(int userId) {
        return PRODUCTS.stream()
                .filter(order -> order.getUserId() == userId)
                .toList();
    }
}