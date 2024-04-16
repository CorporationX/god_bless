package faang.school.godbless.droidSecrets;

public class Main {
    public static void main(String[] args) {
        Droid sender = new Droid();
        Droid receiver = new Droid();
        String massage = "My massage";
        int key = 1;
        String encrypted = sender.sendMessage(massage,key,null);
        String original = receiver.receiveMessage(encrypted,key,null);
        System.out.println(encrypted);
        System.out.println(original);

    }
}
