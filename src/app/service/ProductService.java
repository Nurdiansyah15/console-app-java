package app.service;

import app.model.Product;

import java.util.*;

public class ProductService {
    protected List<Product> productsDb = new ArrayList<>();
    protected int nextId = 1;

    public ProductService() {
        //this.create("Nurdiansyah", 23, "2023-09-12");
        //this.create("Nurdiansyah", 23, "2023-09-12");
        //this.create("Nurdiansyah", 23, "2023-09-12");
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

    //By Name

    public void getAllWithDescendingName() {
        List<Product> productList = this.productsDb.stream().sorted(Comparator.comparing(Product::getName).reversed()).toList();
        for (var list : productList) {
            System.out.println(list);
        }
    }

    public void getAllWithAscendingName() {
        List<Product> productList = this.productsDb.stream().sorted(Comparator.comparing(Product::getName)).toList();
        for (var list : productList) {
            System.out.println(list);
        }
    }

    public void getWithName(String name) {
        for (var v : productsDb) {
            if (Objects.equals(name, v.getName())) {
                System.out.println(v);
            } else {
                continue;
            }
        }
    }

    public void getExcludeName(String name) {
        for (var v : productsDb) {
            if (!Objects.equals(name, v.getName())) {
                System.out.println(v);
            } else {
                continue;
            }
        }
    }

    //By Price

    public void getAllWithDescendingPrice() {
        List<Product> productList = this.productsDb.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList();
        for (var list : productList) {
            System.out.println(list);
        }
    }

    public void getAllWithAscendingPrice() {
        List<Product> productList = this.productsDb.stream().sorted(Comparator.comparing(Product::getPrice)).toList();
        for (var list : productList) {
            System.out.println(list);
        }
    }

    public void getWithPrice(Integer price) {
        for (var v : productsDb) {
            if (price == v.getPrice()) {
                System.out.println(v);
            } else {
                continue;
            }
        }
    }

    public void getExcludePrice(Integer price) {
        for (var v : productsDb) {
            if (v.getPrice() != price) {
                System.out.println(v);
            } else {
                continue;
            }
        }
    }


    //By Expired

    public void getAllWithDescendingExpired() {
        List<Product> productList = this.productsDb.stream().sorted(Comparator.comparing(Product::getExpired).reversed()).toList();
        for (var list : productList) {
            System.out.println(list);
        }
    }

    public void getAllWithAscendingExpired() {
        List<Product> productList = this.productsDb.stream().sorted(Comparator.comparing(Product::getExpired)).toList();
        for (var list : productList) {
            System.out.println(list);
        }
    }

    public void getWithExpired(String expired) {
        Date date = Product.stringToDateFormatter(expired);
        for (var v : productsDb) {
            if (v.getExpired().compareTo(date) == 0) {
                System.out.println(v);
            } else {
                continue;
            }
        }
    }

    public void getExcludeExpired(String expired) {
        Date date = Product.stringToDateFormatter(expired);
        for (var v : productsDb) {
            if (v.getExpired().compareTo(date) != 0) {
                System.out.println(v);
            } else {
                continue;
            }
        }
    }


}
