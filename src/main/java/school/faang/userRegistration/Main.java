package school.faang.userRegistration;

public class Main {
    public static void main(String[] args) {
        User user = new User("Ilya", 25, "Google", "New York");

        System.out.println("Имя: " + user.getName());
        System.out.println("Возраст: " + user.getAge());
        System.out.println("Работа: " + user.getJob());
        System.out.println("Адрес: " + user.getAddress());

        try {
            user.setJob("T Bank");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try{
            user.setAddress("Msk");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            user.setName("");
        }catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            user.setAge(16);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
