package faang.school.godbless.bjs2_11822;

import faang.school.godbless.ColorScheme;

public record SenderRunnable(int startIndex, int endIndex, int id) implements Runnable {
  private static final String EMAILS_PROCESSED = " Писем обработано: ";

  @Override
  public void run() {
    for (int i = startIndex; i <= endIndex; i++) {
      System.out.println(ColorScheme.findByID(id) + Thread.currentThread().getName() + EMAILS_PROCESSED + i);
    }
  }

}
