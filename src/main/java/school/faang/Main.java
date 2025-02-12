package school.faang;

public class Main {
    public static void main(String[] args) {
        User ivan = new User("Ivan", 22, "Uber", "London");
        try {
            User kid = new User("Matthew", 16, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("Вывод данных пользователя: %s \n", ivan);
    }
}
