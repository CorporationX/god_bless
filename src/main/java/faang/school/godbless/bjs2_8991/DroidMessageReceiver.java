package faang.school.godbless.bjs2_8991;

public class DroidMessageReceiver {

  /**
   * ����� ��� ����������� ����������� ���������.
   * @param message ������������� ���������/
   * @param key ���� ����������/
   * @return ���������� �������������� ���������.
   */
  public String receiveEncryptedMessage(String message, int key) {
    return Utils.receiver.droidCommunication(message, key);
  }

}
