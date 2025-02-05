package school.faang;


import school.faang.bjs2_56348.User;

public class Main {
    public static void main(String[] args) {

        try {
            User user1 = new User("Ivan", 24, "Amazon", "London");
            System.out.println(user1);

            User user2 = new User("Irina", 23, "Uber", "New York");
            System.out.println(user2);

            User user3 = new User("Max", 20, "Yandex", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



