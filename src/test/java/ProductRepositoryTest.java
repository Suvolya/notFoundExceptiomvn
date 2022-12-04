import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.notFoundException.NotFoundException;
import ru.netology.notFoundException.Product;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {


    Product product1 = new Product(222, "Книга", 1950);
    Product product2 = new Product(14, "Книга1", 700);
    Product product3 = new Product(1000, "Книга2", 620);

    @Test
    public void testRepositorySave() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRepositoryRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });
    }

    @Test
    public void testRepositoryRemoveByValidId() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(14);

        Product[] expected = {product1, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRepositoryFindAll() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.findAll();

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }
}
