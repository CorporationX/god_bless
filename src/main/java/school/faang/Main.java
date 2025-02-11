package school.faang;

public class Main {
    public static void main(String[] args) {
        User ivan = new User("Ivan", 22, "Uber", "London");
        System.out.printf("Вывод данных пользователя: %s \n", ivan.toString());
    }
}
