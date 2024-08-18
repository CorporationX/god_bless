package faang.school.godbless.BJS2_20965;

public class Main {
    public static void main(String[] args) {
        Droid droid = new Droid();
        String message = "Amirhan1234567890 sdfdfdf";
        String str = droid.sendEncryptedMessage(message, 2);
        System.out.println(str);
        String str2 = droid.receiveEncryptedMessage(str, 2);
        System.out.println(str2);
    }
}
