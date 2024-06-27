package app;

import app.service.ProductService;
import app.utils.InputHandler;

import java.util.Objects;

public class ConsoleApp {
    private final ProductService productService;
    private final InputHandler input;
    private String searchOption;

    public ConsoleApp(ProductService productService, InputHandler inputHandler) {
        this.productService = productService;
        this.input = inputHandler;
    }


    public void run() {
        while (true) {
            boolean nest1 = false;
            showMenu();
            switch (input.getInt("Input Choice : ")) {
                case 1:
                    productService.create(input.getString("Masukan nama: "), input.getInt("Masukan price: "), input.getString("Masukan expired: "));
                    break;
                case 2:
                    productService.getAll();
                    break;
                case 3:
                    productService.getById(input.getInt("Masukan id: "));
                    break;
                case 4:
                    Integer id = input.getInt("Masukan id: ");
                    System.out.println("Data saat ini :");
                    productService.getById(id);
                    productService.update(id, input.getString("Perbarui nama: "), input.getInt("Perbarui price: "), input.getString("Perbarui expired: "));
                    break;
                case 5:
                    productService.delete(input.getInt("Masukan id: "));
                    break;
                case 6:
                    System.out.println("Pilih antara :");
                    System.out.println("1. Name");
                    System.out.println("2. Price");
                    System.out.println("3. Date");
                    System.out.println("4. Cancel");
                    int option = input.getInt("Search product by ?: ");
                    if (option == 1) {
                        this.searchOption = "name";
                    } else if (option == 2) {
                        this.searchOption = "price";
                    } else if (option == 3) {
                        this.searchOption = "expired";
                    } else if (option == 4) {
                        break;
                    } else {
                        System.out.println("Input Tidak Valid");
                    }
                    nest1 = true;
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input Tidak Valid");
                    break;
            }
            while (nest1) {
                showMenuNest();
                switch (input.getInt("Input Choice : ")) {
                    case 1:
                        if (Objects.equals(this.searchOption, "name")) {
                            productService.getAllWithDescendingName();
                        } else if (Objects.equals(this.searchOption, "price")) {
                            productService.getAllWithDescendingPrice();
                        } else if (Objects.equals(this.searchOption, "expired")) {
                            productService.getAllWithDescendingExpired();
                        }
                        break;
                    case 2:
                        if (Objects.equals(this.searchOption, "name")) {
                            productService.getAllWithAscendingName();
                        } else if (Objects.equals(this.searchOption, "price")) {
                            productService.getAllWithAscendingPrice();
                        } else if (Objects.equals(this.searchOption, "expired")) {
                            productService.getAllWithAscendingExpired();
                        }
                        break;
                    case 3:
                        if (Objects.equals(this.searchOption, "name")) {
                            productService.getWithName(input.getString("Masukan nama: "));
                        } else if (Objects.equals(this.searchOption, "price")) {
                            productService.getWithPrice(input.getInt("Masukan price: "));
                        } else if (Objects.equals(this.searchOption, "expired")) {
                            productService.getWithExpired(input.getString("Masukan expired: "));
                        }
                        break;
                    case 4:
                        if (Objects.equals(this.searchOption, "name")) {
                            productService.getExcludeName(input.getString("Masukan nama: "));
                        } else if (Objects.equals(this.searchOption, "price")) {
                            productService.getExcludePrice(input.getInt("Masukan price: "));
                        } else if (Objects.equals(this.searchOption, "expired")) {
                            productService.getExcludeExpired(input.getString("Masukan expired: "));
                        }
                        break;
                    case 5:
                        nest1 = false;
                        break;
                    default:
                        System.out.println("Input Tidak Valid");
                        break;
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("--- Product App ---");
        System.out.println("1. Create product");
        System.out.println("2. Get all product");
        System.out.println("3. Get a product by id");
        System.out.println("4. Update a product");
        System.out.println("5. Delete a product");
        System.out.println("6. Search product by ...");
        System.out.println("7. Exit");
        System.out.println("--------------------");
    }

    private void showMenuNest() {
        System.out.println("Search product by " + this.searchOption);
        System.out.println("1. Sort descending");
        System.out.println("2. Sort ascending");
        System.out.println("3. Find a product by " + this.searchOption);
        System.out.println("4. Find all products excluding by " + this.searchOption);
        System.out.println("5. Back to main menu");
        System.out.println("----------------------");
    }

}
