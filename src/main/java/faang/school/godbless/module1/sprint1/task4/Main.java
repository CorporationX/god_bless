package faang.school.godbless.module1.sprint1.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = null;
        try (Scanner sc = new Scanner(System.in)) {
            user = new User(sc.nextLine(), sc.nextInt(), sc.nextLine(), sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(user);
        }

    }
}
