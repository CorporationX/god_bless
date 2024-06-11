package faang.school.godbless.bjs2_9022;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class InventoryManager {

  /**
   * ����� ��� ���������� �������� � ��������� ���������.
   * @param character ��������
   * @param item ����������� �������
   * @param consumer
   */
  public void addItem(Character character, Item item, Consumer<String> consumer) {
    character.getInventory().add(item);
    consumer.accept(item.getName());
  }

  /**
   * ����� ��� �������� �������� �� ��������� ���������
   * @param character ��������
   * @param item ��������� �������
   * @param isItem
   */
  public void removeItem(Character character, Item item, BiPredicate<Item, Item> isItem) {
    character.getInventory().stream()
        .filter(currentItem -> isItem.test(item, currentItem))
        .findFirst()
        .ifPresent(currentItem -> character.getInventory().remove(item));
  }

  /**
   * ����� ��� ��������� �������� � ��������� ���������.
   * @param character ��������
   * @param item ���������� �������.
   * @param isItem
   * @param function
   */
  public void updateItem(Character character,
                         Item item,
                         BiPredicate<Item, Item> isItem,
                         Function<Item, Integer> function) {
    character.getInventory().forEach(currentItem -> {
      if (isItem.test(item, currentItem)) {
        currentItem.setValue(function.apply(item));
      }
    });
  }

}
