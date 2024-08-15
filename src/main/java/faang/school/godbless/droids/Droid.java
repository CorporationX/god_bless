package faang.school.godbless.droids;

import java.util.Set;

public class Droid {

    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] mc = m.toCharArray();
            for (int i = 0; i < mc.length; i++) {
                boolean isCapital = mc[i] < 91 && mc[i] > 64;
                boolean isLowercase = mc[i] < 123 && mc[i] > 96;
                 //��� ��� ����� ��� ����, ����� ����
                // ������� ��������� ������������, � ����� ����� ���������� ��������, ��� �������������� ��� ���������
                //� ��� ������������ ������ ����������� � ����� �� �����(������ ��� ��� ��������� ������ ������������� ��
                // ������� ��������� �� �����)
                if (".,!? ".contains(String.valueOf(mc[i]))) {
                    mc[i] += (char) (k%3);
                } else {
                    mc[i] += (char) (k % 256);//���� ����� ���� ������� �������
                }

                if (isCapital) {//���������
                    mc[i] = (char) (65 + (mc[i] - 65) % 26);//����� ��� �������� �������� �������
                } else if (isLowercase) {//��������
                    mc[i] = (char) (97 + (mc[i] - 97) % 26);
                }
                //��� ��������� ������ - ��� �� ��������� ������� (�������, ����� ����������)
                //�� �� ����� ��������
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
                if (isCapital) {//��������� �����
                    mc[i] = (char) (90 - (90 - mc[i]) % 26);
                } else if (isLowercase) {//��������
                    mc[i] = (char) (122 - (122 - mc[i]) % 26);
                }
            }
            return String.valueOf(mc);
        };
        return encryptor.encrypt(message, key);
    }
}
