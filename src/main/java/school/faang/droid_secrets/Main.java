package school.faang.droid_secrets;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid("B2-03");
        Droid droid2 = new Droid("N9-9");

        String message = "Hello Droid!";
        int encryptKey = 3;

        droid1.sendMessage(droid2, message, encryptKey);
    }
}
