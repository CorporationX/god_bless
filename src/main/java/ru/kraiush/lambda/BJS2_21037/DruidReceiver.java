package ru.kraiush.lambda.BJS2_21037;

public class DruidReceiver {

    private final String alphabet = Common.alphabet;

    public String constructMessage(String message, int key, DruidMessageEncryptor encryptor) {
        return encryptor.getMessage(message, key);
    }

    public String receiveEncryptedMessage(String input, int key) {

        StringBuilder sb = new StringBuilder();

        return constructMessage(input, key, (s, k) -> {

            String[] alphaString = alphabet.split(" ");

            char[] alphaArray = Common.convertStringArrayToChar(alphaString);
            char[] alphaReversedArray = Common.reverseUseTempArr(alphaArray);
            char[] inputArray = input.toCharArray();

            for (char item : inputArray) {
                int count = 0;
                for (Character letter : alphaReversedArray) {
                    if (item == ' ') {
                        sb.append(' ');
                    }
                    if (item == letter) {
                        for (int q = 0; q < alphaArray.length; q++) {
                            if (count == q) {
                                sb.append(alphaArray[q]);
                            }
                        }
                        break;
                    }
                    count++;
                }
            }
            return sb.toString();
        });
    }
}

