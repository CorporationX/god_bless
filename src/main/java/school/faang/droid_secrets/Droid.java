package school.faang.droid_secrets;

import school.faang.lord_of_the_rings_rpg.Character;

public class Droid {
    public String encryptMessage(int encryptKey, String message) {
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
            } else {
                result =
            }
        }
    }

    public String decryptMessage(int encryptKey, String message);
    public void sendMessage(String message, int encryptKey, Droid droid);
    public void receiveMessage(String message, int encryptKey);

}
