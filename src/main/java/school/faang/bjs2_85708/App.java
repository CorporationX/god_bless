package school.faang.bjs2_85708;

public class App {

    public static void main(String[] args) {
        final User validUser = new User("Anton", 18, User.VALID_JOBS.get(1), User.VALID_ADDRESSES.get(0));
        final User userNotValidAge = new User("Ivan", 15, User.VALID_JOBS.get(1),
                User.VALID_ADDRESSES.get(0));
        final User userNotValidJob = new User("Oleg", 18, "Yandex", User.VALID_ADDRESSES.get(0));
        final User userBlankName = new User("   ", 18, User.VALID_JOBS.get(1), User.VALID_ADDRESSES.get(0));
        final User userNotValidAddress = new User("Elena", 18, User.VALID_JOBS.get(1),
                "Pushkin street");
    }
}