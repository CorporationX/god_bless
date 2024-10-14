package school.faang.multithreading.microsoft;

public class MailSender {

  public static void main(String[] args) {

    for (int i = 0; i < 5; i++) {
      new Thread(new SenderRunnable(i * 200, (i + 1) * 200 - 1)).start();
    }
  }

}
