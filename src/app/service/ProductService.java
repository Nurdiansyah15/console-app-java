package app.service;

import app.model.Product;
import app.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    protected List<Product> productsDb = new ArrayList<>();
    protected int nextId = 1;
    protected FileHandler fileHandler;


    public ProductService() {
        //this.create("Nurdiansyah", 23, "2023-09-12");
        //this.create("Nurdiansyah", 23, "2023-09-12");
        //this.create("Nurdiansyah", 23, "2023-09-12");
        this.fileHandler = new FileHandler("src/app/data.csv");
        productsDb.addAll(fileHandler.readFromFileCsv());
        if (!productsDb.isEmpty()) {
            this.nextId = productsDb.stream().mapToInt(Product::getId).max().orElse(0) + 1;
        }
    }

    public Product create(String name, Integer price, String date) {
        Product temp = new Product();
        temp.setId(nextId++);
        temp.setName(name);
        temp.setPrice(price);
        temp.setExpired(date);
        productsDb.add(temp);
        System.out.println("Created!! " + temp);
        return temp;
    }

    public void getAll() {
        for (var v : productsDb) {
            System.out.println(v);
        }
    }

    public void getById(Integer id) {
        for (var v : productsDb) {
            if (id == v.getId()) {
                System.out.println(v);
                return;
            } else {
                System.out.println("Not found");
            }
        }
    }

    public void update(Integer id, String name, Integer price, String date) {
        for (Product product : productsDb) {
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                product.setExpired(date);
                return;
            }
        }
    }

    public void delete(Integer id) {
        for (int i = 0; i < productsDb.size(); i++) {
            if (productsDb.get(i).getId() == id) {
                productsDb.remove(productsDb.get(i));
            }
        }
    }
}
