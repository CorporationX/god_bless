package school.faang.BJS2_58700;

public class Main {
    public static void main(String[] args) {
        try {
            User userOne = new User("Sam", 8, "Google", "Amsterdam");
            User userTwo = new User("Yan", 29, "Apple", "Washington");
            User userThree = new User("Artur", 19, "Uber", "Berlin");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}