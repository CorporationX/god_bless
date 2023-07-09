package faang.school.godbless;

public class Ravens {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom 1");
        Kingdom kingdom2 = new Kingdom("Kingdom 2");
        Kingdom kingdom3 = new Kingdom("Kingdom 3");

        // Отправка сообщений асинхронно с обработкой результатов
        kingdom1.sendMessage(kingdom2)
                .handle((message, ex) -> {
                    if (ex == null) {
                        System.out.println("Handling message 1: " + message);
                    } else {
                        System.out.println("Error message 1: " + ex.getMessage());
                    }
                    return null;
                });

        kingdom2.sendMessage(kingdom3)
                .handle((message, ex) -> {
                    if (ex == null) {
                        System.out.println("Handling message 2: " + message);
                    } else {
                        System.out.println("Error message 2: " + ex.getMessage());
                    }
                    return null;
                });

        kingdom3.sendMessage(kingdom1)
                .handle((message, ex) -> {
                    if (ex == null) {
                        System.out.println("Handling message 3: " + message);
                    } else {
                        System.out.println("Error message 3: " + ex.getMessage());
                    }
                    return null;
                });
    }
}
