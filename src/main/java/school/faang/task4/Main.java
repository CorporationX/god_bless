package school.faang.task4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестирование валидных данных");
        try {
            User user1 = new User("Ярослав", 19, "Google", "London");
            System.out.println("Успешно создан: " + user1.getName());

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nТестирование невалидных данных");

        // пустое имя
        try {
            User user = new User("", 20, "Uber", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // возраст меньше 18-ти
        try {
            User user = new User("Егор", 17, "Amazon", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // невалидное место работы
        try {
            User user = new User("Петя", 24, "", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // невалидный адрес
        try {
            User user = new User("Маша", 22, "Google", "");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // неверный адрес
        try {
            User user = new User("Сергей", 35, "Amazon", "Russia");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // работа с null
        try {
            User user = new User(null, 24, "Uber", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
