package Sprint_3_Task15;

public class Droid {
    private String sendEncryptedMessage(String message,int encryptionKey) {
        StringBuilder strBox = new StringBuilder(message.length());
        char tmp;
        for (int i = 0; i < message.length(); i++) {
            tmp = message.toLowerCase().charAt(i);
            if (Character.isLetter(message.charAt(i))) {
                tmp += encryptionKey % 26;
                if (tmp > 'z')
                    tmp = (char) (tmp % 'z' + 'a' - 1);
                else if (tmp < 'a')
                    tmp = (char) (tmp + 26);
            }
            strBox.append(tmp);
        }
        return strBox.toString();
    }
    public String receiveEncryptedMessage(String message,int encryptionKey){
        StringBuilder strBox = new StringBuilder(message.length());
        char tmp;
        for (int i = 0; i < message.length(); i++) {
            tmp = message.toLowerCase().charAt(i);
            if (Character.isLetter(message.charAt(i))) {
                tmp += (encryptionKey*-1) % 26;
                if (tmp > 'z')
                    tmp = (char) (tmp % 'z' + 'a' - 1);
                else if (tmp < 'a')
                    tmp = (char) (tmp + 26);
            }
            strBox.append(tmp);
        }
        return strBox.toString();
    }

    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;
        System.out.println(message);
        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println(encryptedMsg);
        System.out.println(msg);
    }
}
