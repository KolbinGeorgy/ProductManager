package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Repository Repository = new Repository();


    Product Smartphone = new Smartphone(22222, "Apple", 100_000, "США");
    Product Book = new Book(12345, "Мастер и Маргарита", 600, "Булгаков");
    Product Book2 = new Book(555, "Война и мир", 500, "Толстой");
    Product Smartphone2 = new Smartphone(1023, "Samsung", 97_000, "Южная Корея");

    @BeforeEach
    public void Product() {

        Repository.save(Smartphone);
        Repository.save(Book);
        Repository.save(Book2);
        Repository.save(Smartphone2);

    }

    @Test

    public void shouldSaveProduct() {

        Product[] actual = Repository.getAll();

        Product[] expected = {
                Smartphone,
                Book,
                Book2,
                Smartphone2
        };

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void shouldRemoveById() {


        Repository.removeById(22222);

        Product[] actual = Repository.getAll();
        Product[] expected = {
                Book,
                Book2,
                Smartphone2
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByTwoId() {


        Repository.removeById(22222);
        Repository.removeById(1023);

        Product[] actual = Repository.getAll();
        Product[] expected = {
                Book,
                Book2,
        };


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllId() {


        Repository.removeById(22222);
        Repository.removeById(1023);
        Repository.removeById(12345);
        Repository.removeById(555);


        Product[] actual = Repository.getAll();
        Product[] expected = {};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            Repository.removeById(22);
        });
    }


}