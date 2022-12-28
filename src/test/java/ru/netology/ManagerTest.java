package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {
    Repository Repository = new Repository();
    Manager Manager = new Manager(Repository);

    Product Smartphone = new Smartphone(22222, "Apple", 100_000, "США");
    Product Book = new Book(12345, "Мастер и Маргарита", 600, "Булгаков");
    Product Book2 = new Book(555, "Война и Мир", 500, "Толстой");
    Product Smartphone2 = new Smartphone(1023, "Samsung", 97_000, "Южная Корея");

    @BeforeEach
    public void Product() {

        Manager.add(Smartphone);
        Manager.add(Book);
        Manager.add(Book2);
        Manager.add(Smartphone2);

    }


    @Test
    public void shouldFindName() {

        Product[] actual = Manager.searchBy("Война и Мир");
        Product[] expected = {Book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindName() {


        Product[] actual = Manager.searchBy("Иванов");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFewProducts() {


        Product[] actual = Manager.searchBy("М");
        Product[] expected = {Book, Book2};
        assertArrayEquals(expected, actual);
    }


}
