package school.faang.bjs2_72985;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MailService {
    private static final Random random = new Random();

    private MailService() {
    }

    public static List<Mail> getMails(int startIndex, int endIndex) {
        List<Mail> mails = new ArrayList<>();

        for (int i = 0; i < (endIndex - startIndex); i++) {
            mails.add(new Mail(getRandomString(10), getRandomString(100)));
        }
        return mails;
    }

    private static String getRandomString(int length) {
        int leftLimit = 97; // 'a'
        int rightLimit = 122; // 'z'

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
