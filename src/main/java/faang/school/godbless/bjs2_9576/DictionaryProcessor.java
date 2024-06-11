package faang.school.godbless.bjs2_9576;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

  public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
    biConsumer.accept(word, translation);
  }

}
