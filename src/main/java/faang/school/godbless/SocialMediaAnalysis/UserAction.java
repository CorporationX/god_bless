package faang.school.godbless.SocialMediaAnalysis;

import lombok.Data;
import java.util.Random;

@Data
public class UserAction {
    public static final Random RANDOM = new Random();

    int id;
    String name;
    String actionType;
    String actionDate;
    String content;

    public UserAction(int id, String name, String actionType, String actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

    public static int generateRandomInt(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static String generateRandomName() {
        String[] names = {"Vlad", "Bob", "Olav", "Dmitry", "August", "Herald", "Travis", "Yana", "Anton", "Joshua", "Misha", "Daniel"};
        return names[RANDOM.nextInt(names.length)];
    }

    public static String generateRandomAction() {
        String[] actions = {"post", "comment", "like", "share"};
        return actions[RANDOM.nextInt(actions.length)];
    }

    public static String generateRandomDate() {
        int year = generateRandomInt(2023, 2024);
        int month = generateRandomInt(1, 12);
        int day = generateRandomInt(1, 28);
        return String.format("%d-%02d-%02d", year, month, day);
    }

    public static String generateRandomContent() {
        String[] contents = {"Hello world!", "Nice post!", "Interesting!", "Me in Philadelphia", "Started studing at Faang School!", "Bonjour", "Vlad posted new video on youtube!!!"};
        String[] hashtags = {"#WOW", "#FUN", "#OMG", "#HOT", "#NEW", "#AMAZING"};

        boolean includeHashtag = RANDOM.nextBoolean();

        if (includeHashtag) {
            String randomContent = contents[RANDOM.nextInt(contents.length)];
            String randomHashtag = hashtags[RANDOM.nextInt(hashtags.length)];
            return randomContent + " " + randomHashtag;
        } else {
            return contents[RANDOM.nextInt(contents.length)];
        }
    }
}
