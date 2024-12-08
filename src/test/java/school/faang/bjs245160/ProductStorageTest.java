package school.faang.bjs245160;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ProductStorageTest {
    public static final String INVALID_CATEGORY = "invalidCategory";
    public static final String INVALID_NAME = "invalidName";

    private final ProductStorage productStorage = new ProductStorage();

    @BeforeEach
    public void setUp() {
        productStorage.getProductsByCategory().clear();
    }

    @Test
    public void addItemTest() {
        ProductData productData = ProductData.PRODUCT_A;
        addAndCheckProduct(productData.getName(), productData.getCategory());
    }

    @Test
    public void removeItemTest() {
        ProductData productData = ProductData.PRODUCT_A;
        addAndCheckProduct(productData.getName(), productData.getCategory());

        productStorage.removeItem(productData.getCategory(), productData.getName());
        Assertions.assertEquals(List.of(), productStorage.getProductsByCategory().get(productData.getCategory()));
    }

    @Test
    public void removeItemInvalidCategoryTest() {
        ProductData productData = ProductData.PRODUCT_A;
        addAndCheckProduct(productData.getName(), productData.getCategory());

        try {
            productStorage.removeItem(INVALID_CATEGORY, productData.getName());
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(String.format("Category: \"%s\" does not exist", INVALID_CATEGORY), e.getMessage());
        }
    }

    @Test
    public void removeItemInvalidNameTest() {
        ProductData productData = ProductData.PRODUCT_A;
        addAndCheckProduct(productData.getName(), productData.getCategory());

        try {
            productStorage.removeItem(productData.getCategory(), INVALID_NAME);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(String.format("Product: \"%s\" does not exist", INVALID_NAME), e.getMessage());
        }
    }

    @Test
    public void findItemsByCategoryTest() {
        ProductData productData = ProductData.PRODUCT_A;
        addAndCheckProduct(productData.getName(), productData.getCategory());

        List<Product> products = productStorage.findItemsByCategory(productData.getCategory());
        Assertions.assertEquals(List.of(productData.createProduct()), products);
    }

    @Test
    public void findItemsByCategoryInvalidCategoryTest() {
        ProductData productData = ProductData.PRODUCT_A;
        addAndCheckProduct(productData.getName(), productData.getCategory());

        try {
            productStorage.findItemsByCategory(INVALID_CATEGORY);
        } catch (Exception e) {
            Assertions.assertEquals(String.format("Category: \"%s\" does not exist", INVALID_CATEGORY), e.getMessage());
        }
    }

    @Test
    public void printAllItemsTest() {
        ProductData productData = ProductData.PRODUCT_A;
        addAndCheckProduct(productData.getName(), productData.getCategory());
        productStorage.printAllItems();
    }

    private void addAndCheckProduct(String name, String category) {
        productStorage.addItem(category, name);

        Map<String, List<Product>> products = productStorage.getProductsByCategory();
        Assertions.assertEquals(List.of(new Product(name, category)), products.get(category));
    }
}
