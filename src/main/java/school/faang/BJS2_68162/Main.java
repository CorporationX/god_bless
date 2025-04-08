package school.faang.BJS2_68162;

public class Main {
    public static void main(String[] args) {
        User correctUser = correctUser();
        System.out.println(correctUser);

        User incorrectUser = incorrectUser();
        System.out.println(incorrectUser);
    }

    private static User correctUser() {
        return new User(
                "Daniyal",
                22,
                "Amazon",
                "London"
        );
    }

    private static User incorrectUser() {
        return new User(
                "Daniyal",
                22,
                "Sun",
                "Moscow"
        );
    }
}
