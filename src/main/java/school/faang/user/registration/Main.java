package school.faang.user.registration;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(new User("Iya",  24, "Uber", "London"));
            System.out.println(new User("Barbie", 16, "Uber", "London"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
