package school.faang.bjs2_85490;

public class Main {
    public static void main(String[] args) {
        User pavel = new User("Pavel", 29, "Google", "New York");
        User oleg = new User("Oleg", 45, "Amazon", "London");
        User egor = new User("Egor", 23, "Uber", "Amsterdam");

        try {
            new User("", 11, "Alt Studio", "Surgut");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new User("Pavel", 11, "Alt Studio", "Surgut");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new User("Pavel", 20, "Alt Studio", "Surgut");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new User("Pavel", 20, "Google", "Surgut");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
