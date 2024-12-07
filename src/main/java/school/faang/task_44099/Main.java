package school.faang.task_44099;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.task_44099.User.findHobbyLovers;
import static school.faang.task_44099.Utils.formatHobbyLoversPrettyView;
import static school.faang.task_44099.Utils.getRandomHobbiesList;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Alice", 30,
                new String[]{"reading", "hiking", "painting", "yoga", "cooking"}));
        userList.add(new User(2, "Bob", 25,
                new String[]{"coding", "gaming", "sports", "music", "photography"}));
        userList.add(new User(3, "Olivia", 35,
                new String[]{"cooking", "traveling", "coding", "reading", "hiking"}));
        userList.add(new User(4, "David", 22,
                new String[]{"music", "photography", "dancing", "gaming", "sports"}));
        userList.add(new User(5, "Eve", 28,
                new String[]{"writing", "drawing", "knitting", "yoga", "traveling"}));
        userList.add(new User(6, "Kelly", 32,
                new String[]{"gardening", "birdwatching", "reading", "hiking", "fishing"}));
        userList.add(new User(7, "Grace", 27,
                new String[]{"coding", "gaming", "volunteering", "yoga", "music"}));
        userList.add(new User(8, "Henry", 40,
                new String[]{"cooking", "traveling", "photography", "painting", "writing"}));
        userList.add(new User(9, "Eve", 24,
                new String[]{"dancing", "music", "sports", "reading", "knitting"}));
        userList.add(new User(10, "Jack", 38,
                new String[]{"coding", "gaming", "hiking", "cooking", "gardening"}));
        userList.add(new User(11, "Kelly", 29,
                new String[]{"traveling", "photography", "yoga", "reading", "birdwatching"}));
        userList.add(new User(12, "Liam", 31,
                new String[]{"painting", "drawing", "music", "volunteering", "sports"}));
        userList.add(new User(13, "Mia", 26,
                new String[]{"coding", "knitting", "gaming", "cooking", "traveling"}));
        userList.add(new User(14, "Noah", 37,
                new String[]{"hiking", "fishing", "reading", "yoga", "photography"}));
        userList.add(new User(15, "Olivia", 23,
                new String[]{"dancing", "music", "writing", "drawing", "gardening"}));

        Set<String> hobbiesList = getRandomHobbiesList(userList);
        Map<User, String> hobbyLovers = findHobbyLovers(userList, hobbiesList);
        log.info("Hobby lovers list: {}", formatHobbyLoversPrettyView(hobbyLovers));
    }
}