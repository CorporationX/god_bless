package school.faang.bjs2_68197;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Name1", 16, "Company1", "Address1"),
                new User("Name2", 17, "Company2", "Address2"),
                new User("Name3", 18, "Company3", "Address3"),
                new User("Name4", 19, "Company4", "Address4"),
                new User("Name5", 20, "Company5", "Address5"),
                new User("Name6", 16, "Company6", "Address6"),
                new User("Name7", 17, "Company7", "Address7"),
                new User("Name8", 18, "Company8", "Address8"),
                new User("Name9", 19, "Company9", "Address9"),
                new User("Name10", 20, "Company10", "Address10"),
                new User("Name11", 16, "Company11", "Address11"),
                new User("Name12", 17, "Company12", "Address12"),
                new User("Name13", 18, "Company13", "Address13"),
                new User("Name14", 19, "Company14", "Address14"),
                new User("Name15", 20, "Company15", "Address15")
        );

        log.info(User.groupUsers(users).toString());
    }
}
