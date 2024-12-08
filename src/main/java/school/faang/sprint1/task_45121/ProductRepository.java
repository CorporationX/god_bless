package school.faang.sprint1.task_45121;

import java.util.*;

public class ProductRepository {

    private HashMap<String, ArrayList<Product>> categoryProductMap = new HashMap<>();

    public HashMap<String, ArrayList<Product>> getCategoryProductMap() {
        return categoryProductMap;
    }

    public void addItem(String category, String name) {
        Random random = new Random();
        Product product = new Product(random.nextLong(), name, category);
        categoryProductMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public void removeItem(String category, String name) {
        ArrayList<Product> products = categoryProductMap.get(category);
        if (products != null) {
            products.removeIf(product -> product.getName().equals(name));
        }
    }

    public List<Product> findItemsByCategory(String category) {
        return categoryProductMap.get(category);
    }

    public void printAllItems() {
        System.out.println("----- ALL ITEMS -----");
        for (Map.Entry<String, ? extends List<Product>> spellEventEntry : categoryProductMap.entrySet()) {
            System.out.printf(
                    "items: %s \n",
                    spellEventEntry.getValue()
            );
        }
    }

    public void printAllItems(Map<String, ArrayList<Product>> map) {
        System.out.println("----- ALL ITEMS -----");
        for (Map.Entry<String, ? extends List<Product>> spellEventEntry : map.entrySet()) {
            System.out.printf(
                    "items: %s \n",
                    spellEventEntry.getValue()
            );
        }
    }
}
