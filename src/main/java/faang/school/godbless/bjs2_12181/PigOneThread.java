package faang.school.godbless.bjs2_12181;

import lombok.SneakyThrows;

public class PigOneThread extends PigThread {

  private static final String FIRST_STORY_FIRST_PIG = "%s не был строителем, но ему надоело жить в овраге";
  private static final String SECOND_STORY_FIRST_PIG = "%s решил сходить в поле и насобирать %s";
  private static final String THIRD_STORY_FIRST_PIG = "Дом из %s был поход на шалаш";

  public PigOneThread(String pigName, String material) {
    super(pigName, material);
  }

  @SneakyThrows
  @Override
  public void run() {
    System.out.println(String.format(FIRST_STORY_FIRST_PIG, this.getPigName()));
    Thread.sleep(1000);
    System.out.println(String.format(SECOND_STORY_FIRST_PIG, this.getPigName(), this.getMaterial()));
    Thread.sleep(1000);
    super.run();
    Thread.sleep(1000);
    System.out.println(String.format(THIRD_STORY_FIRST_PIG, this.getMaterial()));
  }
}
