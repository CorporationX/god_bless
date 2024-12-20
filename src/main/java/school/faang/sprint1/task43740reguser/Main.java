package school.faang.sprint1.task43740reguser;

import java.util.logging.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IllegalArgumentException {
        try {
            User user = new User("Maxim", 17, "Google", "London");
            System.out.println(user.getName());
        } catch (Exception e) {
            log.info("Ошибка создания Юзера");
        }
    }
}
