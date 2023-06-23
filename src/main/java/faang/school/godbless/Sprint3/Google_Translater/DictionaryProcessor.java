package faang.school.godbless.Sprint3.Google_Translater;

public class DictionaryProcessor {
    public void processWord(String word, String translateWord, BiConsumer consumer){
        consumer.add(word,translateWord);
    }
}
