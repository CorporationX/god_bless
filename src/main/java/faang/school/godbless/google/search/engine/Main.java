package faang.school.godbless.google.search.engine;

public class Main {
    public static void main (String[] args) {
        Index index = new Index();

        index.addWebPageToIndex(new WebPage("javarush.com", "java intro", "best java, java, java, introduction"));
        index.addWebPageToIndex(new WebPage("javamagics.com", "JAVA Magics", "best java java java java intro course"));
        index.addWebPageToIndex(new WebPage("javaguru.com", "learn java with me", "let's get deep into Java."));
        index.addWebPageToIndex(new WebPage("vk.com", "javascript intro", "best. best. best. javascript. intro"));
        index.addWebPageToIndex(new WebPage("learn-javascript.com", "javascript learning", "best javascript tutorial"));
        index.addWebPageToIndex(new WebPage("javarush.com", "java intro", "best java course"));
        index.addWebPageToIndex(new WebPage("javamagics.com", "JAVA Maps", "java maps for dummies"));

        System.out.println(index.getWebPagesIndexedByKeyword());
        System.out.println(index.getIndexByKeyword("JAVA"));

        index.removeWebPageFromIndexByUrl("javarush.com");

        System.out.println(index.getWebPagesIndexedByKeyword());
        System.out.println(index.getIndexByKeyword("JAVA"));
    }
}
