package faang.school.godbless.sprint1.transaltor;

/**
 * @author Evgenii Malkov
 */
public class DictionaryProcessor {
  public void processWord(String word, String translation, BiConsumer<String, String> translationHandler) {
    translationHandler.doAction(word, translation);
  }
}
