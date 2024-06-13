package faang.school.godbless.BJS2_9537;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
  public void processWord(String word, String translate, BiConsumer<String, String> addWord) {
    addWord.accept(word, translate);
  }
}
