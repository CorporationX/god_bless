package school.faang.bjs250805;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.combiningItems().join();
        inventory.getItems().forEach(System.out::println);
    }
}