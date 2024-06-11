package faang.school.godbless.transaltor;

/**
 * @author Evgenii Malkov
 */
public class DictionaryProcessor {
  public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
    biConsumer.doAction(word, translation);
  }
}
