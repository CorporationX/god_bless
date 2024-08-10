package faang.school.godbless.BJS2_20187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final String NO_VALID_REGEX_PUNCTUATION = "[ .,?/;:\"'!%]";
    private static final int NO_VALID_KEY_WORDS_LENGTH = 1;
    private static Map<String, List<WebPage>> pagesIndex = new HashMap<>();
    private static Map<String, List<String>> urlKeyWordsIndex = new HashMap<>();

    private static Set<String> getKeyWordsFromContent(WebPage page) {
        Set<String> keyWordsFromContent = new HashSet<>();
        String content = page.getContent();
        for (String word : content.split(NO_VALID_REGEX_PUNCTUATION)) {
            if (!word.isBlank() && word.length() > NO_VALID_KEY_WORDS_LENGTH) {
                String keyWord = word.toLowerCase();
                keyWordsFromContent.add(keyWord);
            }
        }
        return keyWordsFromContent;
    }

    private static void indexingNewPage(WebPage page) {
        for (String word : getKeyWordsFromContent(page)) {
            pagesIndex.computeIfAbsent(word, keyWord -> new ArrayList<>()).add(page);
            String url = page.getUrl();
            urlKeyWordsIndex.computeIfAbsent(url, keyUrl -> new ArrayList<>()).add(word);
        }
    }

    private static void searchByWord(String word) {
        String keyWord = word.replaceAll(NO_VALID_REGEX_PUNCTUATION, "").toLowerCase();
        if (pagesIndex.containsKey(keyWord)) {
            pagesIndex.get(keyWord).forEach(System.out::println);
        }
    }

    private static void removePageByUrl(String url) {
        if (urlKeyWordsIndex.containsKey(url)) {
            for(String keyWord : urlKeyWordsIndex.get(url)) {
                List<WebPage> webPages = pagesIndex.get(keyWord);
                webPages.removeIf(webPage -> url.equals(webPage.getUrl()));
            }
        }
    }

    public static void main(String[] args) {
        indexingNewPage(new WebPage("https://example.com/book1", "1984", "A dystopian novel by George Orwell about a totalitarian regime that uses surveillance, censorship, and propaganda to control its citizens."));
        indexingNewPage(new WebPage("https://example.com/book2", "To Kill a Mockingbird", "Harper Lee's classic novel that explores the themes of racial injustice and moral growth through the eyes of young Scout Finch."));
        indexingNewPage(new WebPage("https://example.com/book3", "Brave New World", "Aldous Huxley's dystopian novel where technology, conditioning, and a caste system govern society, raising questions about freedom and happiness."));
        indexingNewPage(new WebPage("https://example.com/book4", "Pride and Prejudice", "Jane Austen's novel about Elizabeth Bennet's journey through love, society, and family expectations in 19th century England."));
        indexingNewPage(new WebPage("https://example.com/book5", "The Great Gatsby", "F. Scott Fitzgerald's exploration of the American Dream through the tragic story of Jay Gatsby, a mysterious millionaire with a past."));
        indexingNewPage(new WebPage("https://example.com/book6", "Moby-Dick", "Herman Melville's epic tale of obsession and revenge, following Captain Ahab's relentless pursuit of the white whale, Moby-Dick."));
        indexingNewPage(new WebPage("https://example.com/book7", "Crime and Punishment", "Fyodor Dostoevsky's psychological novel about a young man who commits a murder and grapples with guilt, morality, and redemption."));
        indexingNewPage(new WebPage("https://example.com/book8", "The Catcher in the Rye", "J.D. Salinger's novel about teenage angst and alienation, narrated by the disillusioned Holden Caulfield as he navigates life in New York City."));
        indexingNewPage(new WebPage("https://example.com/book9", "The Hobbit", "J.R.R. Tolkien's fantasy adventure that follows Bilbo Baggins, a hobbit who embarks on a journey with dwarves to reclaim their treasure from a dragon."));
        indexingNewPage(new WebPage("https://example.com/book10", "War and Peace", "Leo Tolstoy's epic novel set during the Napoleonic Wars, exploring the lives of several Russian aristocratic families and the impact of history on their destinies."));

        pagesIndex.forEach((keyWord, pages) -> {
            System.out.println(keyWord + ": ");
            pages.forEach(page -> {
                System.out.println("\t" + page);
            });
        });

        removePageByUrl("https://example.com/book2");
        searchByWord("And");
    }
}
