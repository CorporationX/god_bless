package faang.school.godbless.BJS2_5126;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
  public void processWord(String word, String translate, BiConsumer<String, String> biConsumer) {
    biConsumer.accept(word, translate);
  }
}
