package school.faang.bjs2_85648_users_registration;

public class Main {
    public static void main(String[] args) {
        // Попытка создать пользователя с неверными данными
        try {
            // Код, который может вызвать исключение, помещаем сюда
            System.out.println("Пытаемся создать пользователя с возрастом 17...");
            User alfa = new User("Alfa", 17, "Google", "London");
            System.out.println("Пользователь Alfa создан (эта строка не выполнится)"); // до сюда не дойдет
        } catch (IllegalArgumentException e) {
            // Этот блок выполнится, если в блоке try было поймано исключение
            System.out.println("Ошибка при создании Alfa: " + e.getMessage());
        }

        // Программа не упала, и мы можем продолжить
        System.out.println("\nПродолжаем выполнение...");

        // Создаем корректного пользователя
        try {
            User beta = new User("Beta", 22, "Google", "London");
            System.out.println("Успешно создан пользователь: " + beta);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании Beta: " + e.getMessage());
        }

        // Программа не упала, и мы можем продолжить
        System.out.println("\nПродолжаем выполнение...");

        // Попытка создать пользователя с отсутствующими данными
        try {
            System.out.println("Пытаемся создать пользователя с возрастом 17...");
            User gamma = new User("", 33, "Uber", "Amsterdam");
            System.out.println("Пользователь gamma создан (эта строка не выполнится)");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании gamma: " + e.getMessage());
        }
    }
}
