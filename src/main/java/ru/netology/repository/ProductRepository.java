package ru.netology.repository;

import ru.netology.notFoundException.NotFoundException;
import ru.netology.notFoundException.Product;

public class ProductRepository {
    private Product[] products = new Product[0];
    private int id;

    public void save(Product goods) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = goods;
        products = tmp;

    }

    public void removeById(int id) {
            if (findById(id) == null) {
                throw new NotFoundException(
                        "Id не может быть null:" + id
                );
            }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }


    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] getProducts() {
        return  products;
    }

    public Product[] findAll() {
        return new Product[products.length];
    }
}
