package faang.school.godbless.base_priem;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Slf4j
public class EncryptionUtils {
    private final String SECRET_ENCRYPTION_WORD = "BasePriemItIsKey";
    private final SecretKeySpec KEY = new SecretKeySpec(SECRET_ENCRYPTION_WORD.getBytes(), "AES");

    public byte[] encryptMessage(String messageToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, KEY);
            return cipher.doFinal(messageToEncrypt.getBytes());
        } catch (NoSuchAlgorithmException e) {
            log.error("Could not find such algorithm ", e);
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            log.error("Could not find such padding ", e);
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            log.error("Keyword is invalid  ", e);
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            log.error("Block size is illegal ", e);
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            log.error("Padding was bad ", e);
            throw new RuntimeException(e);
        }
    }

    public String decryptMessage(byte[] encryptedBytes) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, KEY);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes, 0, encryptedBytes.length);
            return Arrays.toString(decryptedBytes);
        } catch (NoSuchAlgorithmException e) {
            log.error("Could not find such algorithm ", e);
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            log.error("Could not find such padding ", e);
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            log.error("Keyword is invalid  ", e);
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            log.error("Block size is illegal ", e);
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            log.error("Padding was bad ", e);
            throw new RuntimeException(e);
        }
    }
}
