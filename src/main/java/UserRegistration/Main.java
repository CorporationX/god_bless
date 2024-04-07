package UserRegistration;

public class Main {
    public static void main(String[] args) {
        try {
            User userSanje = new User("Sanje", 20, "Uber", "New York");
        } catch (IllegalArgumentException exeption) {
            System.out.println(exeption.getMessage());
        }
    }

}
