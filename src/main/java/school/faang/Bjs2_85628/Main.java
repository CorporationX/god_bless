package school.faang.Bjs2_85628;

public class Main {

    public static void main(String[] args) {
        User user1 = userRegistration("Ivan", 20, "Amazon", "Амстердам");
        User user2 = userRegistration("", 20, "Amazon", "Амстердам");
        User user3 = userRegistration("Ivan", 17, "Amazon", "Амстердам");
        User user4 = userRegistration("Gleb", 21, "Microsoft", "Амстердам");
        User user5 = userRegistration("Nicola", 25, "Amazon", "Москва");
    }

    private static User userRegistration(String name, int age, String workPlace, String address) {
        User user = null;
        try {
            user = new User(name, age, workPlace, address);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка регистрации: " + ex.getMessage());
        }

        return user;
    }
}
