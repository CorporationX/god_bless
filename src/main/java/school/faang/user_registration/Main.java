package school.faang.user_registration;


public class Main {

    public static void main(String[] args) {
        try {
            new User("Kane", 20, "Google", "London");
            new User("Jane", 17, "Uber", "New York");
            new User("Kyle", 22, "SBER", "London");
            new User("", 22, "AMAZON", "New York");
            new User("Dmitry", 27, "Yandex", "Moscow");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}