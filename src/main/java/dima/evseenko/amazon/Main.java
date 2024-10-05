package dima.evseenko.amazon;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        productService.addProducts(getProducts());
        productService.addProduct(new Product(8L, "Apple iPhone 16 Pro Max 256GB", Category.PHONE));
        productService.printProducts();
        productService.printGroupedProductsByCategory();

        productService.deleteProduct(1L);
        productService.deleteProduct(new Product(2L, "Actina PC MT 3600 16GB", Category.PC));
        productService.printProducts();

        System.out.println(ProductService.groupProductsByCategory(productService.getProducts()));
        System.out.println(productService.getProductsByCategory(Category.PHONE));
        System.out.println(productService.findProduct(5L));

        System.out.println(productService.getProductsByCategory(null));
    }

    private static List<Product> getProducts() {
        return List.of(
                new Product(1L, "Actina PC MT 5500 16GB", Category.PC),
                new Product(2L, "Actina PC MT 3600 16GB", Category.PC),
                new Product(3L, "Actina PC MT i5-12400", Category.PC),
                new Product(4L, "HP 250 G9 15.6 FHD i3-1215U", Category.NOTEBOOK),
                new Product(5L, "Lenovo IdeaPad 1 15IGL7", Category.NOTEBOOK),
                new Product(6L, "Samsung A057G Galaxy A05s", Category.PHONE),
                new Product(7L, "JVC LT40VF4101", Category.TV)
        );
    }
}
