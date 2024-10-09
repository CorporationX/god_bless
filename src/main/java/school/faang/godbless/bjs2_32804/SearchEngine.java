package school.faang.godbless.bjs2_32804;

import lombok.AllArgsConstructor;

import java.util.*;

public class SearchEngine {
    private final Map<String, List<WebPage>> index = new HashMap<>();
    private static final Set<Character> PUNCTUATION = Set.of('.', ',', '?', '!');
    private static final Set<StopWord> STOP_WORDS = Set.of(
            new StopWord("a"),
            new StopWord("are"),
            new StopWord("is"),
            new StopWord("am"),
            new StopWord("the")
    );

    public void addToIndex(WebPage page) {
        StringTokenizer tokenizer = new StringTokenizer(page.getContent());
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            word = PUNCTUATION.contains(word.charAt(word.length() - 1)) ? word.substring(0, word.length() - 1) : word;
            if (word.isEmpty() || STOP_WORDS.contains(new StopWord(word))) {
                continue;
            }
            index.computeIfAbsent(word, key -> new ArrayList<>()).add(page);
        }
    }

    public Optional<List<WebPage>> findPages(String word) {
        return index.containsKey(word) ? Optional.of(index.get(word)) : Optional.empty();
    }

    public void removeByUrl(String url) {
        index.forEach((key, value) -> value.removeIf(page -> page.getUrl().equals(url)));
    }

    @AllArgsConstructor
    private static class StopWord {
        private String word;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StopWord stopWord)) return false;
            return word.equalsIgnoreCase(stopWord.word);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(word.toLowerCase());
        }
    }
}
