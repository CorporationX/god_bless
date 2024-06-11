package faang.school.godbless.bjs2_9150;

public class SpellCaster {

  /**
   * Методо вывода результа выполнения заклинания.
   * @param spellName имя заклинания
   * @param spellAction
   */
  public void cast(String spellName, SpellAction spellAction) {
    System.out.println(spellAction.action(spellName));
  }

}
