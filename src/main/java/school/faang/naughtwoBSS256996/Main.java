package school.faang.naughtwoBSS256996;

import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        addProductsToStore(productManager);
        productManager.addProduct(Category.valueOf("FOOD"), "cheese");

        Optional<Set<Product>> optionalProductSet = productManager.findProductsByCategory(Category.valueOf("FOOD"));
        if (optionalProductSet.isPresent()) {
            Set<Product> productsByCategory = optionalProductSet.get();
            printNameProductForSet(productsByCategory);
        }

        System.out.println();
        productManager.removeProduct(Category.valueOf("FOOD"), "banana");

        productManager.printAllProducts();
    }

    private static void printNameProductForSet(Set<Product> productSet) {
        for (Product product : productSet) {
            System.out.printf("- %s%n", product.getName());
        }
    }
    private static void addProductsToStore(ProductManager productManager) {
        productManager.addProduct(Category.valueOf("FOOD"), "banana");
        productManager.addProduct(Category.valueOf("FOOD"), "cheese");
        productManager.addProduct(Category.valueOf("ELECTRONICS"), "tablet");
        productManager.addProduct(Category.valueOf("ELECTRONICS"), "camera");
        productManager.addProduct(Category.valueOf("CLOTHING"), "jacket");
        productManager.addProduct(Category.valueOf("CLOTHING"), "shorts");
        productManager.addProduct(Category.valueOf("OTHER"), "notebook");
        productManager.addProduct(Category.valueOf("OTHER"), "pen holder");
        productManager.addProduct(Category.valueOf("FURNITURE"), "sofa");
        productManager.addProduct(Category.valueOf("FURNITURE"), "cabinet");
        productManager.addProduct(Category.valueOf("TOYS"), "car toy");
        productManager.addProduct(Category.valueOf("TOYS"), "puzzle");
        productManager.addProduct(Category.valueOf("BOOKS"), "thriller");
        productManager.addProduct(Category.valueOf("BOOKS"), "guidebook");
        productManager.addProduct(Category.valueOf("BEAUTY"), "face mask");
        productManager.addProduct(Category.valueOf("BEAUTY"), "lip balm");
        productManager.addProduct(Category.valueOf("SPORTS"), "basketball");
        productManager.addProduct(Category.valueOf("SPORTS"), "tennis racket");
        productManager.addProduct(Category.valueOf("AUTOMOTIVE"), "brake pads");
        productManager.addProduct(Category.valueOf("AUTOMOTIVE"), "car battery");
        productManager.addProduct(Category.valueOf("FOOD"), "orange juice");
        productManager.addProduct(Category.valueOf("FOOD"), "ice cream");
        productManager.addProduct(Category.valueOf("ELECTRONICS"), "smartwatch");
        productManager.addProduct(Category.valueOf("ELECTRONICS"), "headphones");
        productManager.addProduct(Category.valueOf("CLOTHING"), "sweater");
        productManager.addProduct(Category.valueOf("CLOTHING"), "hat");
        productManager.addProduct(Category.valueOf("OTHER"), "phone case");
        productManager.addProduct(Category.valueOf("OTHER"), "mouse pad");
        productManager.addProduct(Category.valueOf("FURNITURE"), "bookshelf");
        productManager.addProduct(Category.valueOf("FURNITURE"), "dining table");
        productManager.addProduct(Category.valueOf("TOYS"), "action figure");
        productManager.addProduct(Category.valueOf("TOYS"), "board game");
        productManager.addProduct(Category.valueOf("BOOKS"), "biography");
        productManager.addProduct(Category.valueOf("BOOKS"), "comic book");
        productManager.addProduct(Category.valueOf("BEAUTY"), "nail polish");
        productManager.addProduct(Category.valueOf("BEAUTY"), "hair serum");
        productManager.addProduct(Category.valueOf("SPORTS"), "golf clubs");
        productManager.addProduct(Category.valueOf("SPORTS"), "yoga mat");
        productManager.addProduct(Category.valueOf("AUTOMOTIVE"), "gear oil");
        productManager.addProduct(Category.valueOf("AUTOMOTIVE"), "car seat cover");
    }
}
