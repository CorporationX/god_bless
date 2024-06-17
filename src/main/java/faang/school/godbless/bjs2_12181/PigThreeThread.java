package faang.school.godbless.bjs2_12181;

import lombok.SneakyThrows;

public class PigThreeThread extends PigThread {

  private static final String FIRST_STORY_THIRD_PIG = "%s был профессиональным стоителем и всегда мечтал постоить себе дом";
  private static final String SECOND_STORY_THIRD_PIG = "%s пошел в магазин покупать %s";
  private static final String THIRD_STORY_THIRD_PIG = "Дом из %s получился надежным и большим";

  public PigThreeThread(String pigName, String material) {
    super(pigName, material);
  }

  @SneakyThrows
  @Override
  public void run() {
    System.out.println(String.format(FIRST_STORY_THIRD_PIG, this.getPigName()));
    Thread.sleep(3000);
    System.out.println(String.format(SECOND_STORY_THIRD_PIG, this.getPigName(), this.getMaterial()));
    Thread.sleep(3000);
    super.run();
    Thread.sleep(1000);
    System.out.println(String.format(THIRD_STORY_THIRD_PIG, this.getMaterial()));
  }
}
