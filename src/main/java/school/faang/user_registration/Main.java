package school.faang.user_registration;


public class Main {

    public static void main(String[] args) {
        try {
            new RegUser("Kane", 20, "Google", "London");
            new RegUser("Jane", 17, "Uber", "New York");
            new RegUser("Kyle", 22, "SBER", "London");
            new RegUser("", 22, "AMAZON", "New York");
            new RegUser("Dmitry", 27, "Yandex", "Moscow");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}

