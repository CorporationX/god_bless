package faang.school.godbless.google;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Map<String, List<WebPage>> index = new HashMap<>();
    Main searchEngine = new Main(index);

    @BeforeEach
    void setUp() {
        searchEngine.indexWebPage( new WebPage("http://www.facecrook.com/", "Facecrook", "A social network for scammers and con artists."));
        searchEngine.indexWebPage( new WebPage("http://www.amazoff.com/", "Amazoff", "An online store where items are always \"on the way\"."));
        searchEngine.indexWebPage( new WebPage("http://www.youchoob.com/", "Youchoob", "A video hosting site with the worst quality content."));
        searchEngine.indexWebPage( new WebPage("http://www.twiddle.com/", "Twiddle", "A social network for meaningless posts"));
        searchEngine.indexWebPage( new WebPage("http://www.linkedout.com/", "LinkedOut", "A site for professionals no one wants to hire."));
        searchEngine.indexWebPage( new WebPage("http://www.netflux.com/", "Netflux", "A streaming platform where video, movies and TV shows are constantly buffering."));
        searchEngine.indexWebPage( new WebPage("http://www.snapflop.com/", "Snapflop", "A messenger where messages automatically disappear before they can be read."));
    }


    @Test
    void searchTest() {
        System.out.println(searchEngine.getWebPages("Video"));
        assertEquals(2, searchEngine.getWebPages("Video").size());

        System.out.println(searchEngine.getWebPages("Social"));
        assertEquals(2, searchEngine.getWebPages("Video").size());
    }

    @Test
    void deletePageTest() {
        searchEngine.deleteWebPage("http://www.youchoob.com/");
        assertEquals(1, searchEngine.getWebPages("Video").size());
    }
}