package school.faang.task_43717;

public class Main {
    public static void main(String[] args) {
        // Пример 1: Пустое имя
        try {
            User user1 = new User("", 25, "Google", "Amsterdam");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage()); // "Имя не может быть пустым"
        }

        // Пример 2: Возраст меньше 18
        try {
            User user2 = new User("Алексей", 17, "Uber", "London");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage()); // "Возраст не может быть меньше 18"
        }

        // Пример 3: Неверная работа
        try {
            User user3 = new User("Мария", 30, "ООО Рога и копыта", "New York");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage()); // "Место работы должно быть содержится в наборе VALID_JOBS"
        }

        // Пример 4: Неверный адрес
        try {
            User user4 = new User("Дмитрий", 40, "Amazon", "Калуга");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage()); // "Адрес должен быть содержится в наборе VALID_ADDRESSES"
        }

        // Пример 5: Все корректно
        try {
            User user5 = new User("Ольга", 29, "Uber", "Amsterdam");
            System.out.println("Пользователь успешно создан");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
