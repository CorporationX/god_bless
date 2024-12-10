package school.faang.task_45142;

public class Main {
    private static final WarehouseManager warehouseManager = new WarehouseManager();

    public static void main(String[] args) {
        initData();

        warehouseManager.printAllItems();
        System.out.println();

        warehouseManager.findItemsByCategory("Vegetable");
        System.out.println();

        warehouseManager.removeItem("Fruit", "Banana");
        System.out.println();

        warehouseManager.printProductsByCategory();
    }

    private static void initData() {
        warehouseManager.addItem("Fruit", "Apple");
        warehouseManager.addItem("Fruit", "Banana");
        warehouseManager.addItem("Vegetable", "Carrot");
        warehouseManager.addItem("Bakery", "Bread");
        warehouseManager.addItem("Dairy", "Milk");
        warehouseManager.addItem("Meat", "Chicken");
        warehouseManager.addItem("Dairy", "Eggs");
        warehouseManager.addItem("Grains", "Rice");
        warehouseManager.addItem("Vegetable", "Potato");
        warehouseManager.addItem("Vegetable", "Tomato");
    }
}
