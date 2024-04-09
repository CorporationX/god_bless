package faang.school.godbless.BJS2_4396;

public class Main {

    public static void main(String[] args) {

        try {
            User kevin = new User("Kevin", 10, "home", "london");
            System.out.println(kevin);
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e);
        }
    }
}
