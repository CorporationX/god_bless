package faang.school.godbless.BJS2_19319;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.BJS2_19319.Main.*;

public class Constants {
    public static Map<String, List<Product>> CORRECT_PRODUCT_CATEGORY_MAP = new HashMap<>() {{
        put("Одежда", List.of(PRODUCT_1, PRODUCT_7));
        put("Обувь", List.of(PRODUCT_2));
        put("Аксессуары", List.of(PRODUCT_3, PRODUCT_6));
        put("Печатная продукция", List.of(PRODUCT_4));
        put("Средство связи", List.of(PRODUCT_5));
    }};
    public static Map<String, List<Product>> INCORRECT_PRODUCT_CATEGORY_MAP = new HashMap<>() {{
        put("Одежда", List.of(PRODUCT_1, PRODUCT_2));
        put("Обувь", List.of(PRODUCT_3, PRODUCT_4, PRODUCT_5));
        put("Аксессуары", List.of(PRODUCT_6, PRODUCT_7));
    }};
}
