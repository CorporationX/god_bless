package ru.kraiush.lambda.BJS2_21037;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DruidProducer {

    private final String alphabet = Common.alphabet;

    public String constructMessage(String message, int key, DruidMessageEncryptor encryptor) {
        return encryptor.getMessage(message, key);
    }

    public String sendEncryptedMessage(String input, int key) {

        StringBuilder sb = new StringBuilder();

        return constructMessage(input, key, (s, k) -> {

            String[] alphaString = alphabet.split(" ");

            char[] alphaArray = Common.convertStringArrayToChar(alphaString);
            char[] alphaReversedArray = Common.reverseUseTempArr(alphaArray);
            char[] inputArray = input.toCharArray();

            for (char item : inputArray) {
                int count = 0;
                for (Character letter : alphaArray) {
                    if (item == ' ') {
                        sb.append(' ');
                    }
                    if (item == letter) {
                        for (int q = 0; q < alphaReversedArray.length; q++) {
                            if (count == q) {
                                sb.append(alphaReversedArray[q]);
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
