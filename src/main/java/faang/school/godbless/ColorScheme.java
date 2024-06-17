package faang.school.godbless;

import java.util.Arrays;
import lombok.Getter;

/**
 * Перечисление, которое будет использоваться для выделения цвета сообщений при работе с потоками.
 */
public enum ColorScheme {
  RESET(1, "\u001B[0m"),
  BLACK(2, "\u001B[30m"),
  RED(3, "\u001B[31m"),
  GREEN(4, "\u001B[32m"),
  YELLOW(5, "\u001B[33m"),
  BLUE(6, "\u001B[34m"),
  PURPLE(7, "\u001B[35m"),
  CYAN(8, "\u001B[36m"),
  WHITE(9, "\u001B[37m");


  private final int id;
  @Getter
  private final String color;

  ColorScheme(int id, String color) {
    this.id = id;
    this.color = color;
  }

  /**
   * Метод для поиска нужного цвета.
   * @param id идентификатор цвета.
   * @return цветовая схема.
   */
  public static String findByID(int id) {
    return Arrays.stream(ColorScheme.values())
        .filter(color -> color.id == id)
        .map(ColorScheme::getColor)
        .findFirst()
        .orElse(RESET.color);
  }

}
