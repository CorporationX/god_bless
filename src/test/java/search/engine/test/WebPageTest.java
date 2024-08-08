package search.engine.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import search.engine.WebPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WebPageTest {
    @Test
    @DisplayName("Testing create WebPage with null arguments")
    void wpTest_createPageWithNullArguments() {
        try {
            URL url = new URI("http://baeldung.com").toURL();
            assertAll(
                    () -> assertThrows(
                            NullPointerException.class,
                            () -> new WebPage(null, "test", "test")
                    ),
                    () -> assertThrows(
                            NullPointerException.class,
                            () -> new WebPage(url, null, "test")
                    ),
                    () -> assertThrows(
                            NullPointerException.class,
                            () -> new WebPage(url, "test", null)
                    )
            );
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Illegal url address");
        }
    }
}
