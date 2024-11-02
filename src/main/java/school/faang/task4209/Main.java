package school.faang.task4209;

import java.util.concurrent.*;
import java.util.concurrent.LinkedBlockingQueue;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

class EncryptionUtils {
    private static final SecretKey KEY;

    static {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            KEY = keyGenerator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка генерации ключа AES", e);
        }
    }

    public static String encrypt(String message) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, KEY);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка шифрования", e);
        }
    }

    public static String decrypt(String encryptedMessage) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, KEY);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
            return new String(cipher.doFinal(decodedBytes));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка расшифровки", e);
        }
    }
}

class MilitaryBase implements Runnable {
    private final String name;
    private final LinkedBlockingQueue<String> inbox = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    public MilitaryBase(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (running) {
            try {
                String encryptedMessage = inbox.poll(1, TimeUnit.SECONDS);
                if (encryptedMessage != null) {
                    String message = EncryptionUtils.decrypt(encryptedMessage);
                    System.out.println(name + " получил сообщение: " + message);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void sendMessage(MilitaryBase destinationBase, String message) {
        String encryptedMessage = EncryptionUtils.encrypt(message);
        destinationBase.inbox.offer(encryptedMessage);
        System.out.println(name + " отправил сообщение: " + message);
    }

    public void stop() {
        running = false;
    }
}

public class Main {
    public static void main(String[] args) {
        MilitaryBase base1 = new MilitaryBase("База 1");
        MilitaryBase base2 = new MilitaryBase("База 2");

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(base1);
        executor.submit(base2);

        base1.sendMessage(base2, "Сообщение от Базы 1 к Базе 2");
        base2.sendMessage(base1, "Сообщение от Базы 2 к Базе 1");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        base1.stop();
        base2.stop();

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Завершение работы системы обмена сообщениями");
    }
}

