package school.faang.bsj_43723;

public class Main {
    public static void main(String[] args) {
        System.out.println(new User("Иван", 19, "Google", "London"));

        try {
            System.out.println(new User("Иван", 17, "Google", "London"));
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }

        try {
            System.out.println(new User("Иван", 19, "ТБанк", "London"));
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }

        try {
            System.out.println(new User("Иван", 19, "Google", "Москва"));
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}
