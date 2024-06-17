package faang.school.godbless.bjs2_12181;

import lombok.SneakyThrows;

public class PigTwoThread extends PigThread {

  private static final String FIRST_STORY_SECOND_PIG = "%s много смотрел обучающего видео о строительстве домов";
  private static final String SECOND_STORY_SECOND_PIG = "%s пошел в лес, чтобы найти много %s";
  private static final String THIRD_STORY_SECOND_PIG = "Дом из %s получился классическим и красивым";

  public PigTwoThread(String pigName, String material) {
    super(pigName, material);
  }

  @SneakyThrows
  @Override
  public void run() {
    System.out.println(String.format(FIRST_STORY_SECOND_PIG, this.getPigName()));
    Thread.sleep(2000);
    System.out.println(String.format(SECOND_STORY_SECOND_PIG, this.getPigName(), this.getMaterial()));
    Thread.sleep(2000);
    super.run();
    Thread.sleep(1000);
    System.out.println(String.format(THIRD_STORY_SECOND_PIG, this.getMaterial()));
  }
}
