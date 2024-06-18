package faang.school.godbless.bjs2_11730;

import faang.school.godbless.ColorScheme;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

@Data
@AllArgsConstructor
public class CashierThread extends Thread {

  private static final String NEW_CUSTOMER_SERVICE = " Кассир id: %d начал обслуживать ного покупателя.";
  private static final String PRODUCT_CHECKED = " Кассир id: %d пробил товар \"%s\" чз касссу.";
  private static final String ALL_PRODUCT_CHECKED = " Все товары покупателя были проверенны.";
  private static final long INSPECTION_TIME = 4000L;

  private int cashierId;
  private String[] customerItems;

  @SneakyThrows
  @Override
  public void run() {
    final String scheme = ColorScheme.findByID(new Random().nextInt(ColorScheme.values().length));
    final String threadName = Thread.currentThread().getName();
    System.out.println(String.format(scheme + threadName + NEW_CUSTOMER_SERVICE, this.cashierId));
    for (int i =0; i < customerItems.length; i++) {
      Thread.sleep(INSPECTION_TIME);
      System.out.println(String.format(scheme + threadName + PRODUCT_CHECKED, this.cashierId, this.customerItems[i]));
    }
    Thread.sleep(INSPECTION_TIME);
    System.out.println(scheme + threadName + ALL_PRODUCT_CHECKED);
  }
}
