package faang.school.godbless.droids;

import java.util.Set;

public class Droid {

    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] mc = m.toCharArray();
            for (int i = 0; i < mc.length; i++) {
                boolean isCapital = mc[i] < 91 && mc[i] > 64;
                boolean isLowercase = mc[i] < 123 && mc[i] > 96;
                 //это все нужно для того, чтобы спец
                // символы правильно кодировались, а иначе может возникнутб ситуация, что закодировалось все правильно
                //а при раскодировке пробел превратился в какую то букву(потому что при кодировке пробел действительно по
                // таблице сместился на букву)
                if (".,!? ".contains(String.valueOf(mc[i]))) {
                    mc[i] += (char) (k%3);
                } else {
                    mc[i] += (char) (k % 256);//если вдруг ключ слишком большой
                }

                if (isCapital) {//заглавные
                    mc[i] = (char) (65 + (mc[i] - 65) % 26);//буквы при смещении остаются буквами
                } else if (isLowercase) {//строчные
                    mc[i] = (char) (97 + (mc[i] - 97) % 26);
                }
                //все остальные случаи - это не буквенные символы (пробелы, знаки препинания)
                //их мы прсто сдвигаем
            }
            return String.valueOf(mc);
        };
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] mc = m.toCharArray();
            for (int i = 0; i < mc.length; i++) {
                boolean isCapital = mc[i] < 91 && mc[i] > 64;
                boolean isLowercase = mc[i] < 123 && mc[i] > 96;
                if (!(isCapital || isLowercase)) {
                    mc[i]-= (char) (k%3);
                } else {
                    mc[i] -= (char) (k % 256);
                }
                if (isCapital) {//заглавные буквы
                    mc[i] = (char) (90 - (90 - mc[i]) % 26);
                } else if (isLowercase) {//строчные
                    mc[i] = (char) (122 - (122 - mc[i]) % 26);
                }
            }
            return String.valueOf(mc);
        };
        return encryptor.encrypt(message, key);
    }
}
