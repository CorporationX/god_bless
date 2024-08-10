package users_registration;

public class Main {
    public static void main(String[] args) {
        User correctUser = new User("Name", 20, "Google", "London");
        User nullUserName = new User(null, 20, "Google", "London");
        User incorrectUserName = new User("  ", 20, "Google", "London");
        User incorrectUserAge = new User("Name", 15, "Google", "London");
        User incorrectUserJob = new User("Name", 20, "Yandex", "London");
        User incorrectUserAddress = new User("Name", 20, "Google", "Tomsk");
    }
}
