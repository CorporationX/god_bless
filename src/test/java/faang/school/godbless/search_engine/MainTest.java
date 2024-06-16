package faang.school.godbless.search_engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void test() {
        Main googleSearch = new Main();
        WebPage google = new WebPage("google.com", "Search anything!", "We collect your data just to match better ads!");
        WebPage amazon = new WebPage("amazon.com", "Buy anything!", "Jeff Bezos");
        WebPage microsoft = new WebPage("microsoft.com", "Big bro watching you", "We just collect your data, and want to take screenshots of your screen every minute and feed to gpt just to help you navigate your data!");
        WebPage uber = new WebPage("uber.com", "Why my ride is 40 dollars??", "4 page app doesnt need 200 designers, snapchat");

        googleSearch.indexPage(google);
        googleSearch.indexPage(amazon);
        googleSearch.indexPage(microsoft);
        googleSearch.indexPage(uber);

        System.out.println(googleSearch.search("data"));
        System.out.println(googleSearch.search("uber"));
        System.out.println(googleSearch.search("watching"));
        googleSearch.hostServerGoesOffline("microsoft.com");
        System.out.println(googleSearch.search("watching"));
    }

}