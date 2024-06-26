package app.utils;

import app.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final File file;

    public FileHandler(String pathname) {
        this.file = new File(pathname);
    }

    public List<Product> readFromFileCsv() {
        List<Product> products = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String contentInLine;
                while ((contentInLine = br.readLine()) != null) {
                    products.add(Product.fromCsv(contentInLine));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("File not found!");
        }
        return products;
    }

    public void writeToFileCsv(List<Product> products) {
        if (file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (Product product : products) {
                    bw.write(product.toCsv());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("File not found!");
        }
    }

    public File getFile() {
        return file;
    }
}
