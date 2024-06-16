package BJS2_7864;

public class Main {
    public static void main(String[] args) {
        try {
            User wrong = new User("Сергей", 33, "Koogle", "London");
            System.out.println(wrong);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User correct = new User("Андрей", 34, "Amazon", "New York");
            System.out.println(correct);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
