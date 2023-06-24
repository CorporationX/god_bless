package faang.school.godbless.secrets_of_droids;


public class Main {
    public static void main(String[] args) {
        Droid droid = new Droid();

        String message = """
                Теперь моя пора: я не люблю весны;
                Скучна мне оттепель; вонь, грязь — весной я болен;
                Кровь бродит; чувства, ум тоскою стеснены.
                Суровою зимой я более доволен,
                Люблю ее снега; в присутствии луны
                Как легкий бег саней с подругой быстр и волен,
                Когда под соболем, согрета и свежа,
                Она вам руку жмет, пылая и дрожа!
                """;

        int key = 2345;

        String str = droid.sendEncryptedMessage(message, key);
        System.out.println(str);
        String newStr = droid.receiveEncryptedMessage(str, key);
        System.out.println(newStr);
    }
}
