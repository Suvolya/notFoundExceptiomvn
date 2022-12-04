import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.notFoundException.Book;
import ru.netology.notFoundException.Product;
import ru.netology.notFoundException.ProductManager;
import ru.netology.notFoundException.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(222, "Книга1", 1950, "Автор1");
    Product product2 = new Book(14, "Книга2", 700, "Автор2");
    Product product3 = new Smartphone(1000, "Смартфон", 20000, "Производитель");
    Product product4 = new Smartphone(1001, "Смартфон", 15000, "Производитель");


    @Test
    public void shouldSearchNoneProduct() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {};
        Product[] actual = manager.searchBy( "Большая книга");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneProduct() {
        manager.add(product1);
        manager.add(product2);


        Product[] expected = {product2};
        Product[] actual = manager.searchBy( "Книга2");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearcheFewProducts() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);


        Product[] expected = {product3, product4};
        Product[] actual = manager.searchBy( "Смартфон");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchIfMultipleProductsFound() {
        manager.add(product1);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Книга1");

        Assertions.assertArrayEquals(expected, actual);
    }

}
