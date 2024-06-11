package faang.school.godbless.bjs2_8991;

import lombok.Data;

@Data
public class Droid {
  private String savedMessage;

  /**
   * ����� ��� ���������� ��������� (������)
   * @param droid �����, �������� �� �������� ���������
   * @param message ������������ ���������
   * @param key ���� ����������
   */
  public void sendEncryptedMessage(Droid droid, String message, int key) {
    droid.savedMessage = Utils.encryptor.droidCommunication(message, key);
  }

}
