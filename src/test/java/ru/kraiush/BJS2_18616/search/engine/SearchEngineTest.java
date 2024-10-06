package ru.kraiush.BJS2_18616.search.engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.search.engine.SearchEngine;
import school.faang.search.engine.WebPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchEngineTest {
    private static final String KEYWORD = "одна";

    private SearchEngine searchEngine;
    private WebPage page;

    @BeforeEach
    public void setUp() throws IOException {
        searchEngine = new SearchEngine();
        String content = Files.readString(Path.of("src/main/resources/habr.txt"));
        page = new WebPage("https://habr.com/", "Habr", content);
    }

    @Test
    public void testAdd() {
        //act
        searchEngine.add(page);

        //assert
        List<WebPage> pages = searchEngine.getPages(KEYWORD);
        assertTrue(pages.contains(page));
    }

    @Test
    public void testGetPages() {
        //arrange
        searchEngine.add(page);
        List<WebPage> expected = List.of(page);

        //act
        List<WebPage> actual = searchEngine.getPages(KEYWORD);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        //arrange
        searchEngine.add(page);

        //act
        searchEngine.remove(page.getUrl());

        //assert
        List<WebPage> pages = searchEngine.getPages(KEYWORD);
        assertNull(pages);
    }
}
