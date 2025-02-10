package school.faang.naughtwoBSS256996;

import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        addProductsToStore(productManager);
        productManager.addProduct(Category.FOOD, "");

        Optional<Set<Product>> optionalProductSet = productManager.findProductsByCategory(Category.FOOD);
        if (optionalProductSet.isPresent()) {
            Set<Product> productsByCategory = optionalProductSet.get();
            printNameProductForSet(productsByCategory);
        }

        System.out.println();
        productManager.removeProduct(Category.FOOD, "banana");

        productManager.printAllProducts();
    }

    private static void printNameProductForSet(Set<Product> productSet) {
        for (Product product : productSet) {
            System.out.printf("- %s%n", product.getName());
        }
    }

    private static void addProductsToStore(ProductManager productManager) {
        productManager.addProduct(Category.FOOD, "banana");
        productManager.addProduct(Category.FOOD, "cheese");
        productManager.addProduct(Category.ELECTRONICS, "tablet");
        productManager.addProduct(Category.ELECTRONICS, "camera");
        productManager.addProduct(Category.CLOTHING, "jacket");
        productManager.addProduct(Category.CLOTHING, "shorts");
        productManager.addProduct(Category.OTHER, "notebook");
        productManager.addProduct(Category.OTHER, "pen holder");
        productManager.addProduct(Category.FURNITURE, "sofa");
        productManager.addProduct(Category.FURNITURE, "cabinet");
        productManager.addProduct(Category.TOYS, "car toy");
        productManager.addProduct(Category.TOYS, "puzzle");
        productManager.addProduct(Category.BOOKS, "thriller");
        productManager.addProduct(Category.BOOKS, "guidebook");
        productManager.addProduct(Category.BEAUTY, "face mask");
        productManager.addProduct(Category.BEAUTY, "lip balm");
        productManager.addProduct(Category.SPORTS, "basketball");
        productManager.addProduct(Category.SPORTS, "tennis racket");
        productManager.addProduct(Category.AUTOMOTIVE, "brake pads");
        productManager.addProduct(Category.AUTOMOTIVE, "car battery");
        productManager.addProduct(Category.FOOD, "orange juice");
        productManager.addProduct(Category.FOOD, "ice cream");
        productManager.addProduct(Category.ELECTRONICS, "smartwatch");
        productManager.addProduct(Category.ELECTRONICS, "headphones");
        productManager.addProduct(Category.CLOTHING, "sweater");
        productManager.addProduct(Category.CLOTHING, "hat");
        productManager.addProduct(Category.OTHER, "phone case");
        productManager.addProduct(Category.OTHER, "mouse pad");
        productManager.addProduct(Category.FURNITURE, "bookshelf");
        productManager.addProduct(Category.FURNITURE, "dining table");
        productManager.addProduct(Category.TOYS, "action figure");
        productManager.addProduct(Category.TOYS, "board game");
        productManager.addProduct(Category.BOOKS, "biography");
        productManager.addProduct(Category.BOOKS, "comic book");
        productManager.addProduct(Category.BEAUTY, "nail polish");
        productManager.addProduct(Category.BEAUTY, "hair serum");
        productManager.addProduct(Category.SPORTS, "golf clubs");
        productManager.addProduct(Category.SPORTS, "yoga mat");
        productManager.addProduct(Category.AUTOMOTIVE, "gear oil");
        productManager.addProduct(Category.AUTOMOTIVE, "car seat cover");
    }
}
