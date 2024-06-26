package app.service;

import app.model.Product;
import app.utils.FileHandler;

public class FileProductService extends ProductService {
    private  final FileHandler fileHandler;

    public FileProductService(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        this.productsDb = fileHandler.readFromFileCsv();

        if (!productsDb.isEmpty()) {
            this.nextId = productsDb.stream().mapToInt(Product::getId).max().orElse(0) + 1;
        }
    }

    @Override
    public Product create(String name, Integer price, String date) {
        Product product = super.create(name,price,date);
        fileHandler.writeToFileCsv(productsDb);
        return product;
    }
}
