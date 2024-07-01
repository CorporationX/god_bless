package faang.school.godbless.task_1;

import faang.school.godbless.task_1.creature.Creature;
import faang.school.godbless.task_1.creature.models.Angel;
import faang.school.godbless.task_1.creature.models.Griffin;
import faang.school.godbless.task_1.creature.models.Pikeman;
import faang.school.godbless.task_1.creature.models.Swordman;
import faang.school.godbless.task_1.heroes.Hero;
import java.util.List;

/**
 * Класс для имитации поля сражения.
 */
public class Battlefield {

  private static final String VIN_VALUE = "Победил: ";

  //TODO Простейшая схема боя, можно ее развить более масштабней, если в итоге этого требудет задача.
  /**
   * Метод для вычисления победителя.
   * @param heroOne Герой номер один.
   * @param heroTwo Нерой номер два.
   * @return Результат боя.
   */
  public static String battle(Hero heroOne, Hero heroTwo) {
    Integer maxDamageHeroOne = getFullDamage(heroOne.getArmy());
    Integer maxDamageHeroTwo = getFullDamage(heroTwo.getArmy());

    return maxDamageHeroOne > maxDamageHeroTwo ? VIN_VALUE + heroOne.getHeroName() :
        VIN_VALUE + heroTwo.getHeroName();
  }

  /**
   * Медот для получения общего урона от всей армии героя.
   * @param creatures Список армии героя
   * @return общий урон.
   */
  private static Integer getFullDamage(List<Creature> creatures) {
    var result = 0;
    for (Creature creature : creatures) {
      result += creature.getDamage();
    }
    return result;
  }

  public static void main(String[] args) {
    Creature pikeman = new Pikeman("Копейщик", 10, 15, 10, 20, 100);
    Creature griffin = new Griffin("Грифон", 10, 50, 50, 50, 50);
    Creature swordman = new Swordman("Мечник", 10, 10, 20, 10, 150);
    Creature angel = new Angel("Ангел", 10, 80, 100, 70, 30);

    Hero heroOfLight = new Hero("Светлый", "Эльфы", 1000, 10);
    Hero heroOfDark = new Hero("Темный", "Нежить", 500, 9);

    heroOfLight.addCreature(swordman, 2);
    heroOfLight.addCreature(angel, 8);

    heroOfDark.addCreature(pikeman, 10);
    heroOfDark.addCreature(griffin, 2);

    System.out.println(battle(heroOfLight, heroOfDark));
  }

}
