package derschrank.sprint02.task07.bjstwo_46653;

public record Droid(String name) implements DroidInterface {

    @Override
    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor =
                (msg, encryptorNey) -> {
                    StringBuilder resultMessage = new StringBuilder();
                    int countFromAtoZ = 'z' - 'a';
                    for (char ch : message.toCharArray()) {
                        if (Character.isLetter(ch)) {
                            int charA = 'A';
                            if (Character.isLowerCase(ch)) {
                                charA = 'a';
                            }
                            int delta = (ch - charA + key) % countFromAtoZ;
                            if (delta < 0) {
                                delta += countFromAtoZ;
                            }
                            ch = (char) (charA + delta);
                        }
                        resultMessage.append(ch);
                    }
                    return resultMessage.toString();
                };
        return encryptor.encrypt(message, key);
    }

    @Override
    public String decryptMessage(String message, int key) {
        return encryptMessage(message, (-1 * key));
    }

    @Override
    public void sendMessage(Droid destination, String message, int key) {
        message = encryptMessage(message, key);
        System.out.println(this.name + " sent: " + message);
        destination.receiveMessage(message, key);
    }


    @Override
    public void receiveMessage(String message, int key) {
        message = decryptMessage(message, key);
        System.out.println(this.name + " received: " + message + "\n");
    }
}
