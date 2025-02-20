package school.faang;

public class Main {
    public static void main(String[] args) {
        // Задача обрабатываем ошибки красиво
        RemoteService remoteService = new RemoteService();
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        String result = exceptionHandler.withErrorHandling(
                () -> remoteService.call("some Param"),
                e -> {
                    System.out.printf("Ошибка при вызове сервиса: %s\n", e.getMessage());
                    return e.getMessage();
                }
        );
        System.out.println(result);
        
        // Задача Lord of the Rings
        InventoryManager manager = new InventoryManager();

        Character frodo = new Character("Frodo");
        Item ring = new Item("The one Ring", 1000);

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("Предмет: %s был добавлен в инвентарь\n", item.getName()));
        manager.removeItem(frodo, (item) -> item.getName().equals("The one Ring"));

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("Предмет: %s cнова был добавлен в инвентарь\n", item.getName()));
        manager.updateItem(frodo, (item) -> item.getName().equals("The one Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo.getInventory().get(0).getValue());
    }
}
