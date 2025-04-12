package BJS2_69069;

public class Main {
    public static void main(String[] args) {

        try {
            User user1 = new User("Антон", 45, "Uzum", "Novosibirsk");
            User user2 = new User("Петя", 20, "Uber", "Amsterdam");
            User user3 = new User("Саша", 15, "Uber", "Novosibirsk");
        } catch (IllegalArgumentException e){
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}
