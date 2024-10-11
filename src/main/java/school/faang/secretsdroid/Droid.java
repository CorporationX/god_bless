package school.faang.secretsdroid;

public class Droid {
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    private DroidMessageEncryptor encryptor = (m, k) -> {
        String newStr = "";
        for (int i = 0; i < m.length(); i++) {
            if(m.charAt(i) != ' '){
                newStr += (char) (m.charAt(i) + k);
            } else {
                newStr += ' ';
            }
        }
        return newStr;
    };
    public String encryptMessage(String message, Integer key){
        return encryptor.crypto(message, key);
    }

    public String decryptMessage(String message, Integer key) {
        return encryptor.crypto(message, -key);
    }

    public void sendMessage(Droid droid, String message, Integer key) {
        String crypMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + crypMessage);
        droid.receiveMessage(crypMessage, key);
    }

    public void receiveMessage(String message, Integer key) {
        String decryptMessage = decryptMessage(message, key);
        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptMessage);
    }

}