package ru.kraiush.BJS2_18616.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import school.faang.library.Book;
import school.faang.library.Library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    @DisplayName("Добавление книги в библиотеку - позитивный кейс")
    public void add_withCorrectData() {
        //arrange
        Book book = new Book("Алгоритмы на Java", "Р. Седжвик", 2010);

        //act
        library.add(book, "1");

        //assert
        assertEquals("1",
                library.getLocation("Алгоритмы на Java", "Р. Седжвик", 2010));
    }

    @Test
    @DisplayName("Добавление книги в библиотеку - книга null")
    public void add_withBookNull_throwsNullPointerException() {
        //act & assert
        assertThrows(NullPointerException.class, () -> library.add(null, "1"));
    }

    @Test
    @DisplayName("Добавление книги в библиотеку - место книги null")
    public void add_withPlaceNull_throwsIllegalArgumentException() {
        //arrange
        Book book = new Book("Алгоритмы на Java", "Р. Седжвик", 2010);

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> library.add(book, null));
    }

    @Test
    @DisplayName("Добавление книги в библиотеку - место книги пустая строка")
    public void add_withPlaceEmpty_throwsIllegalArgumentException() {
        //arrange
        Book book = new Book("Алгоритмы на Java", "Р. Седжвик", 2010);

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> library.add(book, ""));
    }

    @Test
    @DisplayName("Удаление книги из библиотеки - позитивный кейс")
    public void remove_correctData() {
        //arrange
        Book book = new Book("Алгоритмы на Java", "Р. Седжвик", 2010);
        library.add(book, "1");

        //act
        library.remove("Алгоритмы на Java", "Р. Седжвик", 2010);

        //assert
        assertNull(library.getLocation("Алгоритмы на Java", "Р. Седжвик", 2010));
    }

    @Test
    @DisplayName("Поиск местоположения книги в библиотеку - позитивный кейс")
    public void getLocation_withPresentBook_returnLocation() {
        //arrange
        Book book = new Book("Алгоритмы на Java", "Р. Седжвик", 2010);
        library.add(book, "1");

        //act
        String actual = library.getLocation("Алгоритмы на Java", "Р. Седжвик", 2010);

        //assert
        assertEquals("1", actual);
    }

    @Test
    @DisplayName("Поиск местоположения книги в библиотеку - позитивный кейс")
    public void getLocation_withNonPresentBook_returnNull() {
        //arrange
        Book book = new Book("Алгоритмы на Java", "Р. Седжвик", 2010);
        library.add(book, "1");

        //act
        String actual = library.getLocation("Алгоритмы", "Р. Седжвик", 2010);

        //assert
        assertNull(actual);
    }

    @ParameterizedTest
    @CsvSource({",'Р. Седжвик'", "'Алгоритмы на Java',"})
    @DisplayName("Поиск местоположения книги в библиотеку - title is null, author is null")
    public void getLocation_withArgumentsNull_returnsNull(String title, String author) {
        //arrange
        Book book = new Book("Алгоритмы на Java", "Р. Седжвик", 2010);
        library.add(book, "1");

        //act
        String actual = library.getLocation(title, author, 2010);

        //assert
        assertNull(actual);
    }
}
