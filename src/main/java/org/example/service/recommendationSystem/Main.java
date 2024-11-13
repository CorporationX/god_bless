package org.example.service.recommendationSystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.recommendationSystem.Product;
import org.example.model.recommendationSystem.ProductOrder;
import org.example.model.recommendationSystem.UserProfile;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        RecommendationService recommendationService = new RecommendationService(
                new URL("file:///C:/Users/Zhuba/Downloads/user_profiles.json"),
                new URL("file:///C:/Users/Zhuba/Downloads/products.json"),
                new URL("file:///C:/Users/Zhuba/Downloads/product_orders.json"));


        System.out.println("Получить товары по интересам пользователя: ");
        System.out.println(RecommendationService.getProductsByUserInterests(8));

        System.out.println("\n5 самых покупаемых товаров другими пользователями, у которых такой же пол, возраст и местоположение:");
        System.out.println(RecommendationService.findTopFiveProductsByUserDemographic(11));

        System.out.println("\nКатегория на которую можно предложить скидку пользователю на основе его предыдущих заказов:");
        RecommendationService.getCategoryForDiscount(12).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("not found!")
        );
    }
}
