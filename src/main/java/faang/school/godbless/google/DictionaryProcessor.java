package faang.school.godbless.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
  public void processWord(String originalWord, String translateWord, BiConsumer<String, String> consumerFn) {
    consumerFn.accept(originalWord, translateWord);
  }
}
