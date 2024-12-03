package school.faang.sprint_1.task_43688;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            User goodUser = new User("Ivan", 22, "Google", "London");
            System.out.println(goodUser);

            User badUser = new User("Ivan", 22, "MacDonald", "London");
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error(e.toString());
        }
    }
}