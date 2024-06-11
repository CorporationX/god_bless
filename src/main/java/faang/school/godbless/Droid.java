package faang.school.godbless;

//char A = 'Y';
//        int B = ((int)A + 3 - 64) % 26 + 64;
//        System.out.println((char)B);
//        System.out.println((int)A);
//Создайте класс Droid, который будет иметь метод sendEncryptedMessage,
// сообщение и ключ шифрования. В этом методе должен использоваться DroidMessageEncryptor для шифрования сообщения,
// а затем зашифрованное сообщение передаётся другому дроиду;
//Вообще это шифр Цезаря, с единственным отличием, что Z в нём не переходит в A, а мы просто идём дальше по таблице char
//Вы вводите данное условие, а я же решил задачу с ограничением, что у нас только заглавные буквы без пробелов и препинания, и 0<key<=260.
//тогда Z переходит в A.
public class Droid {
    public String abstractEncrypt(String message, int key, DroidMessageEncryptor droidMessageEncryptor) {
        return droidMessageEncryptor.encrypt(message,key);
    }
    public String sendEncryptedMessage(String message, int key) {
        return abstractEncrypt(message,key,(msg,k) -> {
            char [] result = new char[msg.toCharArray().length];
            int j = 0;
            for(char i:msg.toCharArray()) {
                int temp = ((int)i+k - 64) % 26 + 64;
                result[j] = (char)temp;
                if (result[j]=='@') {
                    result[j]='Z';
                }
                j++;
            }
            return String.valueOf(result);
        });
    }
    public String receiveEncryptedMessage(String message, int key) {
        return abstractEncrypt(message,key,(msg,k) -> {
            char [] result = new char[msg.toCharArray().length];
            int j = 0;
            for(char i:msg.toCharArray()) {
                int temp = ((int)i-k - 64);
                if (temp >= 0) {
                    temp = temp % 26 + 64;
                } else {
                    temp = temp + 260;
                    temp = temp % 26 + 64;
                }
                result[j] = (char)temp;
                if (result[j]=='@') {
                    result[j]='Z';
                }
                j++;
            }
            return String.valueOf(result);
        });
    }
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "MAYTHEFORCEBEWITHYOU";
        int encryptionKey = 56;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println(encryptedMsg);
        System.out.println(msg);
    }
}
