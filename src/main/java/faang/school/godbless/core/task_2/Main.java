package faang.school.godbless.core.task_2;

import faang.school.godbless.core.task_2.model.User;

public class Main {
    public static void main(String[] args) {
        User igor = new User("Igor", 18, "Google", "New York");
        System.out.println("Hello, " + igor.getName());
    }
}