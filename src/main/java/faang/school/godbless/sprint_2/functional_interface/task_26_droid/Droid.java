package faang.school.godbless.sprint_2.functional_interface.task_26_droid;

public class Droid {


    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor messageEncryptor = (m, k) -> {
            StringBuilder sb = new StringBuilder();
            k = shortKey(k);

            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                int bigA = 65;
                int bigZ = 90;
                int litA = 97;
                int litZ = 122;
                if(Character.isAlphabetic(ch)){
                    if(isBig(ch) && (ch + k) > bigZ){
                        sb.append((char)(ch + k - bigZ + bigA - 1));
                    } else if (isLittle(ch) && (ch + k) > litZ){
                        sb.append((char)(ch + k - litZ + litA - 1));
                    } else {
                        sb.append((char)(ch + k));
                    }

                }else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        };

        return messageEncryptor.encrypt(message, encryptionKey);

    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor messageEncryptor = (m, k) -> {
            StringBuilder sb = new StringBuilder();
            k = shortKey(k);

            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                int bigA = 65;
                int bigZ = 90;
                int litA = 97;
                int litZ = 122;
                if(Character.isAlphabetic(ch)){
                    if(isBig(ch) && (ch - k) < bigA){
                        sb.append((char)(ch - k - bigA + bigZ + 1));
                    } else if (isLittle(ch) && (ch - k) < litA){
                        sb.append((char)(ch - k - litA + litZ + 1));
                    } else {
                        sb.append((char)(ch - k));
                    }
                }else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        };

        return messageEncryptor.encrypt(message, encryptionKey);
    }

    private boolean isLittle(char symbol) {
        return symbol >= 97 && symbol <= 122;
    }

    private int shortKey(int encryptionKey){
        return encryptionKey % 26;
    }
    private boolean isBig(char symbol){
        return symbol >= 65 && symbol <= 90;
    }



}
