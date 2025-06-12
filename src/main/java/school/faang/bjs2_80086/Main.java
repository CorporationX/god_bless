package school.faang.bjs2_80086;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        DroidMessageEncryptor caesarCipher = new CaesarCipher().encryptCaesar();
        Droid bb = new Droid("BB", caesarCipher);
        Droid cp9 = new Droid("cp9", caesarCipher);

        int encryptedKey1 = 4;
        int encryptedKey2 = 7;

        bb.sendMessage("cp9", "Hello, cp!", encryptedKey1);
        cp9.sendMessage("bb", "Hello, bb!", encryptedKey2);
    }
}
