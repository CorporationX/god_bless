package faang.school.godbless;

public class Application {
    public static void main(String... args) { // не знаю, может слишком замудренно получилось с методами у Droid, но сделал в соответствии с заданием
        Droid transmitter = new Droid();
        Droid receiver = new Droid();

        String encryptedMessage = transmitter.sendEncryptedMessage("Hello world", 10);
        System.out.println(encryptedMessage);

        receiver.receiveEncryptedMessage(encryptedMessage, 10); // сделал так, что если поставить в key то же самое число,
                                                                     // то он вернет то же выражение, иначе зашифрует по-другому
        System.out.println(receiver.getMessage());
    }
}
