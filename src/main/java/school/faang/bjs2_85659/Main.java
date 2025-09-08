package school.faang.bjs2_85659;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Alesha", 19, "Google", "London"); // Передаем неправильное значение
            System.out.println(user1);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage()); // Сообщение об ошибке попадёт сюда
        }
    }
}
