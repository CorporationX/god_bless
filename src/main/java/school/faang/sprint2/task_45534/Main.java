package school.faang.sprint2.task_45534;

public class Main {
    public static void main(String[] args) {
        Character dmitry = new Character("Dmitry");

        Item ring = new Item("Ring", 40);
        Item knife = new Item("Knife", 79);
        Item helmet = new Item("Helmet", 100);

        dmitry.addItem(ring, (item) -> System.out.println("Added: " + item));
        dmitry.addItem(knife, (item) -> System.out.println("Added: " + item));
        dmitry.addItem(helmet, (item) -> System.out.println("Added: " + item));

        dmitry.printAllItems();

        dmitry.removeItem((item) -> item.getName().equals("Knife"));

        dmitry.printAllItems();

        dmitry.updateItem((item) -> item.getName().equals("Helmet"), (item) ->
                        new Item(item.getName(), item.getValue() * 2));

        dmitry.printAllItems();
    }
}
