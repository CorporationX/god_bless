package faang.school.godbless.user_registration;

public class Main {
    public static void main(String[] args) {
        User vlad = new User(null, 27, "Uber", "Amsterdam");
        User noName = new User("   ", 27, "Uber", "Amsterdam");
        User varya = new User("Varya", 17, "Uber", "Amsterdam");
        User peter = new User("Peter", 27, "RPN", "Amsterdam");
        User anna = new User("Anna", 27, "Uber", "Uryupinsk");
    }
}