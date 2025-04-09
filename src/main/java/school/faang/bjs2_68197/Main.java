package school.faang.bjs2_68197;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>() {{
            add(new User("Name1", 16, "Company1", "Address1"));
            add(new User("Name2", 17, "Company2", "Address2"));
            add(new User("Name3", 18, "Company3", "Address3"));
            add(new User("Name4", 19, "Company4", "Address4"));
            add(new User("Name5", 20, "Company5", "Address5"));
            add(new User("Name6", 16, "Company6", "Address6"));
            add(new User("Name7", 17, "Company7", "Address7"));
            add(new User("Name8", 18, "Company8", "Address8"));
            add(new User("Name9", 19, "Company9", "Address9"));
            add(new User("Name10", 20, "Company10", "Address10"));
            add(new User("Name11", 16, "Company11", "Address11"));
            add(new User("Name12", 17, "Company12", "Address12"));
            add(new User("Name13", 18, "Company13", "Address13"));
            add(new User("Name14", 19, "Company14", "Address14"));
            add(new User("Name15", 20, "Company15", "Address15"));
        }};

        log.info(User.groupUsers(users).toString());
    }
}
