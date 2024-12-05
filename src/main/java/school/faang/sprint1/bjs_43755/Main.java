package school.faang.sprint1.bjs_43755;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Hdhsjdf", 28, "Yandex", "Moscow");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
