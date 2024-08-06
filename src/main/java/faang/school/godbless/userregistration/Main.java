package faang.school.godbless.userregistration;

public class Main {

    public static void main(String[] args) {
        User correctUser = new User("Виктор", 23, "Google", "London");
        User uncorrectUser = new User("", 17, "Скамер", "Ставрополь");
    }
}