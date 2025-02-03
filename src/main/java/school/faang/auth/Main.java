package school.faang.auth;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(new User("Petr", 1984, 6,
                    12, "Hamburg", "Amazon"));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            System.out.println(new User("Ivan", 1984, 6,
                    12, "London", "Uber"));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            System.out.println(new User("Lisa", 1984, 6,
                    12, "Berlin", "Uber"));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            System.out.println(new User("Katy", 1984, 6,
                    12, "Hamburg", "Beiersdorf"));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            System.out.println(new User("Lisa", null, 6,
                    12, "Hamburg", "Uber"));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            System.out.println(new User(null, 1984, 6,
                    12, "Hamburg", "Uber"));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
