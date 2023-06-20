package faang.school.godbless.task.droids;

import java.util.*;

public class Droid {
    public static final String EXCEPTION_KEY_NOT_FOUND = "No key found for this droid";
    public static final String EXCEPTION_DROID_NOT_FOUND = "No messages found for this droid";
    public static final String EXCEPTION_NEGATIVE_KEY_VALUE = "Encrypt key can't be negative";
    public static final String EXCEPTION_USELESS_KEY_VALUE = "The message will not change with this key";
    private Map<Droid, LinkedList<String>> droidMessages;
    private Map<Droid, Integer> droidEncryptKeys;

    public Droid() {
        droidMessages = new HashMap<>();
        droidEncryptKeys = new HashMap<>();
    }

    public void sendEncryptedMessage(Droid droidTo, String message, int encryptKey) {
        assertEncryptKey(encryptKey);

        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> msg.chars()
                .map(ch -> (ch + key) % Character.MAX_VALUE)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String encryptedMessage = droidMessageEncryptor.encryptMessage(message, encryptKey);
        droidTo.getEncryptedMessage(this, encryptedMessage);
    }

    public void getEncryptedMessage(Droid droidFrom, String encryptedMessage) {
        if (droidMessages.containsKey(droidFrom)) {
            droidMessages.get(droidFrom).add(encryptedMessage);
        } else {
            droidMessages.put(droidFrom, new LinkedList<>());
            droidMessages.get(droidFrom).add(encryptedMessage);
        }
    }

    public int getEncryptKey(Droid droid) {
        return Optional.ofNullable(droidEncryptKeys.get(droid)).orElseThrow(() -> new NoSuchElementException(EXCEPTION_KEY_NOT_FOUND));
    }

    public static void pairDroidsWithEncryptKey(Droid droid1, Droid droid2, int encryptKey) {
        assertEncryptKey(encryptKey);

        droid1.droidEncryptKeys.put(droid2, encryptKey);
        droid2.droidEncryptKeys.put(droid1, encryptKey);
    }

    public static void assertEncryptKey(int encryptKey) {
        if (encryptKey < 0) {
            throw new IllegalArgumentException(EXCEPTION_NEGATIVE_KEY_VALUE);
        }

        if (encryptKey % Character.MAX_VALUE == 0) {
            throw new IllegalArgumentException(EXCEPTION_USELESS_KEY_VALUE);
        }
    }

    public String getLastMessageForDroid(Droid droid) {
        return Optional.ofNullable(droidMessages.get(droid))
                .orElseThrow(() -> new NoSuchElementException(EXCEPTION_DROID_NOT_FOUND)).getLast();
    }

    public static void main(String[] args) {
        Droid c3po = new Droid();
        Droid r2d2 = new Droid();
        int encryptKey = 1001;

        Droid.pairDroidsWithEncryptKey(c3po, r2d2, encryptKey);
        c3po.sendEncryptedMessage(r2d2, "Hello there!", c3po.getEncryptKey(r2d2));
        String encryptedMessage = r2d2.getLastMessageForDroid(c3po);

        System.out.println(encryptedMessage);
        System.out.println(DroidMessageReceiver.receiveEncryptedMessage(encryptedMessage, r2d2.getEncryptKey(c3po)));
    }
}
