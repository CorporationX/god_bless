package faang.school.godbless.crow;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
  public static void main(String[] args) {
    Kingdom firstKingdom = new Kingdom("First kingdom");
    Kingdom secondKingdom = new Kingdom("Second kingdom");

    CompletableFuture<String> promise = firstKingdom.sendRaven(secondKingdom, "This is text for kingdom #2");

    System.out.println("Sending message...");

    CompletableFuture<Serializable> resultLambda = promise.handle((result, error) -> {
      if (error != null) {
        return error;
      }

      return result;
    });

    try {
      System.out.println(resultLambda.get());
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }
  }
}
