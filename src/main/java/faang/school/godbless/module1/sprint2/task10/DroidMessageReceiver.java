package faang.school.godbless.module1.sprint2.task10;

public record DroidMessageReceiver(Droid droid) {

    private String encoderMessage(String message, Integer key) {
        return droid.coderMessage(message, 26 - key);
    }

    public void receiveEncryptedMessage(String message, Integer key) {
        DroidMessageEncryptor<String, Integer, String> dme = this::encoderMessage;
        System.out.println(dme.encrypt(message, key));
    }
}
