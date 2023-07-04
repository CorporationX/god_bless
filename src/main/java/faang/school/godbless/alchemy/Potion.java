package faang.school.godbless.alchemy;

public class Potion {
  private String name;
  private int requiredIngredients;
  private int currentIngredients = 0;

  public Potion(String name, int requiredIngredients) {
    this.name = name;
    this.requiredIngredients = requiredIngredients;
  }

  public void addIngredient() {
    currentIngredients++;
  }

  public int getRequiredIngredients() {
    return requiredIngredients;
  }
}
