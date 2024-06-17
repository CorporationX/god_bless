package faang.school.godbless.droids;

public class Main {
    public static void main(String[] args) {
        String message = "Hello my friend";
        int key = 4;
        Droid c3po = new Droid();
        Droid r2d2 = new Droid();
        String messageOne = c3po.sendEncryptedMessage(message,key);
        String answer = r2d2.receiveEncryptedMessage(messageOne,key);
        System.out.println(messageOne);
        System.out.println(answer);
    }
}
