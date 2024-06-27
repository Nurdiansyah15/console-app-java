package app.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    protected Integer id;
    protected String name;
    protected Integer price;
    protected Date expired;


    public Product(int id, String name, int price, String expired) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expired = stringToDateFormatter(expired);
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;

    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public Product(int id) {
        this.id = id;

    }

    public Product() {

    }


    public String toCsv() {
        return this.id + "," + this.name + "," + this.price + "," + dateToStringFormatter(this.expired);
    }

    //u can use without instance
    public static Product fromCsv(String csv) {
        String[] parts = csv.split(",");
        return new Product(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3]);
    }

    public static Date stringToDateFormatter(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = formatter.parse(dateString);
//            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("Invalid date format: " + dateString);
        }
        return date;
    }

    public static String dateToStringFormatter(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expired=" + dateToStringFormatter(expired) +
                '}';
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = stringToDateFormatter(expired);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
