package school.faang.BJS2_58588;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(new User("Garry", 18, "Uber", "London"));
            System.out.println(new User("Dolgopups", 10, "Google", "London"));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

}
