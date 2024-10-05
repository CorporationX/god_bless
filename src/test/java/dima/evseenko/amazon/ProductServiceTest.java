package dima.evseenko.amazon;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductServiceTest {

    @Test
    void addProduct() {
        ProductService productService = new ProductService();
        productService.addProduct(new Product(1L, "Actina PC MT 5500 16GB", Product.Category.PC));

        assertEquals(new Product(1L, "Actina PC MT 5500 16GB", Product.Category.PC), productService.findProduct(1L));
    }

    @Test
    void addNullProduct() {
        ProductService productService = new ProductService();
        productService.addProduct(null);

        assertNull(productService.findProduct(1L));
    }

    @Test
    void addProducts(){
        ProductService productService = new ProductService();
        productService.addProducts(getProducts());

        assertEquals(new Product(1L, "Actina PC MT 5500 16GB", Product.Category.PC), productService.findProduct(1L));
        assertEquals(new Product(2L, "Actina PC MT 3600 16GB", Product.Category.PC), productService.findProduct(2L));
        assertEquals(new Product(3L, "Actina PC MT i5-12400", Product.Category.PC), productService.findProduct(3L));
    }

    @Test
    void addNullProducts() {
        ProductService productService = new ProductService();
        productService.addProducts(null);

        assertNull(productService.findProduct(1L));
    }

    @Test
    void findProduct() {
        ProductService productService = new ProductService();
        productService.addProducts(getProducts());

        assertEquals(new Product(1L, "Actina PC MT 5500 16GB", Product.Category.PC), productService.findProduct(1L));
        assertEquals(new Product(2L, "Actina PC MT 3600 16GB", Product.Category.PC), productService.findProduct(2L));
        assertEquals(new Product(3L, "Actina PC MT i5-12400", Product.Category.PC), productService.findProduct(3L));
    }

    @Test
    void deleteProduct() {
        ProductService productService = new ProductService();
        productService.addProducts(getProducts());
        productService.deleteProduct(1L);

        assertNull(productService.findProduct(1L));
    }

    @Test
    void getProductsByCategory(){
        ProductService productService = new ProductService();
        productService.addProducts(getProducts());

        assertTrue(productService.getProductsByCategory(Product.Category.PC).contains(new Product(1L, "Actina PC MT 5500 16GB", Product.Category.PC)));
        assertTrue(productService.getProductsByCategory(Product.Category.PC).contains(new Product(2L, "Actina PC MT 3600 16GB", Product.Category.PC)));
        assertTrue(productService.getProductsByCategory(Product.Category.PC).contains(new Product(3L, "Actina PC MT i5-12400", Product.Category.PC)));
    }

    @Test
    void groupProductsByCategory(){
        ProductService productService = new ProductService();
        productService.addProducts(getProducts());

        Map<Product.Category, List<Product>> groupedProducts = ProductService.groupProductsByCategory(productService.getProducts());

        assertTrue(groupedProducts.get(Product.Category.PC).contains(new Product(1L, "Actina PC MT 5500 16GB", Product.Category.PC)));
        assertTrue(groupedProducts.get(Product.Category.NOTEBOOK).contains(new Product(4L, "HP 250 G9 15.6 FHD i3-1215U", Product.Category.NOTEBOOK)));
    }

    private List<Product> getProducts() {
        return List.of(
                new Product(1L, "Actina PC MT 5500 16GB", Product.Category.PC),
                new Product(2L, "Actina PC MT 3600 16GB", Product.Category.PC),
                new Product(3L, "Actina PC MT i5-12400", Product.Category.PC),
                new Product(4L, "HP 250 G9 15.6 FHD i3-1215U", Product.Category.NOTEBOOK),
                new Product(5L, "Lenovo IdeaPad 1 15IGL7", Product.Category.NOTEBOOK),
                new Product(6L, "Samsung A057G Galaxy A05s", Product.Category.PHONE),
                new Product(7L, "JVC LT40VF4101", Product.Category.TV)
        );
    }
}