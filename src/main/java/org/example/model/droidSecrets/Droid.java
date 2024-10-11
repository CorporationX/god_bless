package org.example.model.droidSecrets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private static final int startOfTheUpperCaseLetter = 65;
    private static final int endOfTheUpperCaseLatter = 90;
    private static final int startOfTheLowerCaseLetter = 97;
    private static final int endOfTheLowerCaseLetter = 122;
    private static final int sizeOfTheEnglishLetter = 26;
    private String name;

    public static String encryptMessage(String message, Integer key) {
        String result = "";
        for(char messagePart : message.toCharArray()){
            if(Character.isLetter(messagePart)){
                if(messagePart >= startOfTheUpperCaseLetter && messagePart <= endOfTheUpperCaseLatter){
                    result += (char) ((messagePart - startOfTheUpperCaseLetter + key) % sizeOfTheEnglishLetter + startOfTheUpperCaseLetter);
                }else{
                    result += (char) ((messagePart - startOfTheLowerCaseLetter + key) % sizeOfTheEnglishLetter + startOfTheLowerCaseLetter);
                }
            }else{
                result += messagePart;
            }
        }
        return result;
    }

    public static String decryptMessage(String message, Integer key) {
        String result = "";
        for(char messagePart : message.toCharArray()){
            if(Character.isLetter(messagePart)){
                if(messagePart >= startOfTheUpperCaseLetter && messagePart <= endOfTheUpperCaseLatter){
                    result += (char) (endOfTheUpperCaseLatter - (endOfTheUpperCaseLatter - messagePart + key) % sizeOfTheEnglishLetter);
                }else{
                    result += (char) (endOfTheLowerCaseLetter - (endOfTheLowerCaseLetter - messagePart + key) % sizeOfTheEnglishLetter);
                }
            }else{
                result += messagePart;
            }
        }
        return result;
    }

    public void sendMessage(Droid droid, String message, Integer key, DroidMessageEncryptor encryptor) {
        String encryptedMessage = encryptor.doIt(message, key);
        System.out.println(this.getName() + " отправил зашифрованное сообщение: " + encryptedMessage);

        droid.receiveMessage(encryptedMessage, key, Droid::decryptMessage);
    }

    public void receiveMessage(String encryptedMessage, Integer key,  DroidMessageEncryptor decryptor) {
        String decryptedMessage = decryptor.doIt(encryptedMessage, key);
        System.out.println(this.getName() + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
