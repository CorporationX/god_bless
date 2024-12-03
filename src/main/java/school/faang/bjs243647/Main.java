package school.faang.bjs243647;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Dima", 20, "Google", "London");
            System.out.println(user);
            User user1 = new User("Ivan", 30, "Uber", "Amsterdam");
            System.out.println(user1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

}
