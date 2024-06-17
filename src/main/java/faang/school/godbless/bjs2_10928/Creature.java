package faang.school.godbless.bjs2_10928;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
  private int damage;

  /**
   * ����� ��� ��������� ����� �� ��������.
   * @return ����, ������� ����� ������� ��������.
   */
  public abstract int calculateDamage();
}
