package school.faang.userregistration;

public class Main {
    public static void main(String[] args) {
        User user = new User("Ilya", 25, "Google", "New York");

        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Work: " + user.getJob());
        System.out.println("Address: " + user.getAddress());

        try {
            user.setJob("T Bank");
        } catch (IllegalArgumentException e) {
            System.out.println("Misstake: " + e.getMessage());
        }

        try {
            user.setAddress("Msk");
        } catch (IllegalArgumentException e) {
            System.out.println("Miss: " + e.getMessage());
        }

        try {
            user.setName("");
        } catch (IllegalArgumentException e) {
            System.out.println("Miss: " + e.getMessage());
        }

        try {
            user.setAge(16);
        } catch (IllegalArgumentException e) {
            System.out.println("Miss: " + e.getMessage());
        }
    }
}
