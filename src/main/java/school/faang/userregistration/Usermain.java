package school.faang.userregistration;



public class Usermain {
    public static void main(String[] args) {
        try {
            User user = new User("name1", 17, "Google", "London");
            System.out.printf("Пользователи: %s ", user);
        } catch (IllegalAccessException e) {
            System.err.println("Ошибка создания: " + e.getMessage());
        }
        try {
            User user = new User("name2", 18, "Googl", "London");
            System.out.printf("Пользователи: %s ", user);
        } catch (IllegalAccessException e) {
            System.err.println("Ошибка создания: " + e.getMessage());
        }
        try {
            User user = new User("name3", 18, "Google", "Londo");
            System.out.printf("Пользователи: %s ", user);
        } catch (IllegalAccessException e) {
            System.err.println("Ошибка создания: " +  e.getMessage());
        }
        try {
            User user = new User("name4", 18, "Google", "London");
            System.out.printf("Пользователи: %s ", user);
        } catch (IllegalAccessException e) {
            System.err.println("Ошибка создания: " + e.getMessage());
        }
    }
}
