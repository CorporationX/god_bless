package faang.school.godbless.bjs2_9150;

public class SpellCaster {

  /**
   * ������ ������ �������� ���������� ����������.
   * @param spellName ��� ����������
   * @param spellAction
   */
  public void cast(String spellName, SpellAction spellAction) {
    System.out.println(spellAction.action(spellName));
  }

}
