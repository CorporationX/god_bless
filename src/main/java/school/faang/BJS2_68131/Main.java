package school.faang.BJS2_68131;

public class Main {
    public static void main(String[] args) {
        User correctUser = new User("Mike", 19, "Google", "London");
        System.out.println(correctUser);

        User incorrectUser = new User("Mike", 5, "Roga&Kopyta", "Hell");
        System.out.println(incorrectUser);
    }
}
