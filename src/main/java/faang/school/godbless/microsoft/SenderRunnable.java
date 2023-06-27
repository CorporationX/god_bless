package faang.school.godbless.microsoft;

import java.util.List;

public class SenderRunnable implements Runnable {
  List<Number> mails;
  int startIndex;
  int endIndex;

  public SenderRunnable(List<Number> mails, int startIndex, int endIndex) {
    this.mails = mails;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }

  @Override
  public void run() {
    for (int i = startIndex; i < endIndex; i++) {
      System.out.println("Thread: " + Thread.currentThread().getName() + " Mail content: " + mails.get(i));
    }
  }
}
