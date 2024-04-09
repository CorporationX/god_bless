package droidSecrets;

public class DroidMessageReceiver {
    public void receiveEncryptMessage(String message, Integer decoderKey) {
        DroidMessageEncryptor decoder = ((mess, decK) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (char symbol : mess.toCharArray()) {
                stringBuilder.append((char) (symbol-decK));
            }

            return stringBuilder.toString();
        } );

        System.out.println(decoder.encrypt(message, decoderKey));
    }
}
