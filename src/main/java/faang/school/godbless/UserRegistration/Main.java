package faang.school.godbless.UserRegistration;

public class Main {
    public static void main(String[] args) {
        User shrek = new User("shrek", 30, "London", "Google");
        User patrick = new User("shrek", 13, "Bikkini-Bottom", "None"); // тут исключение вылетит
    }
}
