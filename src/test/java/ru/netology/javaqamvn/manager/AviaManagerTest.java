package ru.netology.javaqamvn.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.javaqamvn.domain.AviaSales;
import ru.netology.javaqamvn.repository.AviaRepo;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class AviaManagerTest {
        AviaRepo repository = new AviaRepo();
        AviaManager manager = new AviaManager(repository);
        AviaSales one = new AviaSales(100, 1500, 60, "AAA", "BBB");
        AviaSales two = new AviaSales(200, 2900, 70, "AAA", "BBB");
        AviaSales three = new AviaSales(300, 3500, 80, "AAA", "BBB");
        AviaSales fourth = new AviaSales(400, 4600, 90, "AAA", "BBB");
        AviaSales fifth = new AviaSales(500, 5800, 100, "AAA", "BBB");
        AviaSales sixth = new AviaSales(600, 6900, 200, "AAA", "BBB");

        @BeforeEach
        public void setup() {
            repository.save(one);
            repository.save(two);
            repository.save(three);
            repository.save(fourth);
            repository.save(fifth);

        }

        @Test //Сортировка стоимости билета по возрастанию
        public void sortingTicketPriceTest() {
            AviaSales[] expected = new AviaSales[]{one, two, three};
            AviaSales[] actual = new AviaSales[]{one, two, three};

            Arrays.sort(expected);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test // Добавление еще одного элемента
        public void addingElementTest() {
            repository.save(sixth);

            AviaSales[] actual = repository.findAll();
            AviaSales[] expected = new AviaSales[]{one, two, three, fourth, fifth, sixth};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test // Сортировка по времени
        public void sortingTimeTest() {
            AviaSales[] actual = manager.findAll("AAA", "BBB");
            AviaSales[] expected = new AviaSales[]{one, two, three, fourth, fifth};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test // Неверный аэропорт вылета
        public void incorrectDepartureAirportFromTest() {
            AviaSales[] actual = manager.findAll("ABA", "BBB");
            AviaSales[] expected = new AviaSales[]{};

            Assertions.assertArrayEquals(expected, actual);

            System.out.println(Arrays.toString(actual));
        }

        @Test // Неверный аэропорт прилета
        public void incorrectDepartureAirportToTest() {
            AviaSales[] actual = manager.findAll("AAA", "AAB");
            AviaSales[] expected = new AviaSales[]{};

            Assertions.assertArrayEquals(expected, actual);

            System.out.println(Arrays.toString(actual));
        }

        @Test // Удаление одного элемента
        public void removeElementTest() {
            repository.removeById(100);

            Assertions.assertEquals(repository.findAll().length, 4);
        }

        @Test // Сохранить элементы
        public void saveElementsTest() {
            Assertions.assertEquals(repository.findAll().length, 5);
        }
    }

