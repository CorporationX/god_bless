package gratsio_BJS2_68672;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        pm.addProduct(Category.FOOD, "Молоко");
        pm.addProduct(Category.FOOD, "Яблоко");
        pm.addProduct(Category.FOOD, "Апельсин");
        pm.addProduct(Category.FOOD, "Вода");
        if(pm.findProductsByCategory(Category.FOOD) != null){
            for(Product p : pm.findProductsByCategory(Category.FOOD)){
                System.out.println(p);
            }
        } else {
            System.out.println("В этой категории отсутствуют продукты");
        }
        pm.addProduct(Category.ELECTRONICS, "Телевизор");
        pm.addProduct(Category.ELECTRONICS, "Планшет");
        if(pm.findProductsByCategory(Category.ELECTRONICS) != null){
            for(Product p : pm.findProductsByCategory(Category.ELECTRONICS)){
                System.out.println(p);
            }
        } else {
            System.out.println("В этой категории отсутствуют продукты");
        }
        if(pm.findProductsByCategory(Category.CLOTHING) != null){
            for(Product p : pm.findProductsByCategory(Category.CLOTHING)){
                System.out.println(p);
            }
        } else {
            System.out.println("В этой категории отсутствуют продукты");
        }
        pm.printAllProducts();
    }
}
