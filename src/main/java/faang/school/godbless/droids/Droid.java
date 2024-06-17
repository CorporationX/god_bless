package faang.school.godbless.droids;

public class Droid {
    DroidMessageEncryptor encryptor = (str, hash)->{
        StringBuilder res= new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int asciiValue = (int)str.charAt(i);
            if(asciiValue+hash>255) {
                asciiValue = 255-asciiValue+hash;
                char charToInsert = (char) ((char) asciiValue);
                res.append(charToInsert);
            } else {
                char charToInsert = (char) ((char) asciiValue+hash);
                res.append(charToInsert);
            }
        }
        return res.toString();
    };
    public String sendEncryptedMessage(String message,int key) {

        return encryptor.encrypt(message,key);
    }
    public String receiveEncryptedMessage(String message,int key) {
        return encryptor.encrypt(message,key*-1);
    }
}
