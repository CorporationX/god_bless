package school.faang.task_56431;

import static java.rmi.server.LogStream.log;

public class Main {

    public static void main(String[] args) {
        try {
            User mike = new User("Mike", 23, "Google", "London");
            System.out.printf("Имя: %s\nВозраст: %d\nАдрес: %s\nМесто работы: %s\n.",
                    mike.getName(), mike.getAge(), mike.getAddress(), mike.getJob());
        } catch (Exception e) {
            log(e.getMessage()).println();
        }

    }
}
