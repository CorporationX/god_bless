package school.faang.threeLittlePigs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PigThread extends Thread {
  protected String name;
  @Getter
  @Setter
  protected String material;

  @Override
  public void run() {
    System.out.printf("%s строит из %s\n", name, material);

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }

    System.out.printf("%s достроил свой дом\n", name);
  }

  public String getPigName() {
    return name;
  }

  public void setPigName(String name) {
    this.name = name;
  }
}
