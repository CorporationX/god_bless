package faang.school.godbless.alexbulgakoff.userregistration;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {

        new Thread("t1").start();

        try {
            User correctUser = new User(
                    "John", 23, "Google", "London");
            System.out.println(correctUser);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread("t2").start();

        try {
            User exceptionUser = new User(
                    "Alex", 17, "Uber", "Amsterdam");
            System.out.println(exceptionUser);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
