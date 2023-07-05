package faang.school.godbless.crow;

import java.util.concurrent.CompletableFuture;

public class Kingdom {
  private String name;

  public Kingdom(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public CompletableFuture<String> sendRaven(Kingdom otherKingdom, String message) {
    return CompletableFuture.supplyAsync(() -> {
      if (Math.random() > 0.5){
        return "Message " + message +  " delivered to " + otherKingdom.getName();
      }

      return "Message failed";
    });
  }
}
