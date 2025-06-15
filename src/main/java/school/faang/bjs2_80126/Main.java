package school.faang.bjs2_80126;

public class Main {
    public static void main(String[] args) {
        Droid dygyd = new Droid();
        Droid kdcrijdow = new Droid();

        String message = "hola, dygyd";
        int key = 3;

        System.out.println("kdcrijdow отправляет сообщение dygyd: " + message);
        kdcrijdow.sendMessage(message, key, dygyd);
    }
}
