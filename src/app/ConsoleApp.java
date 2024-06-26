package app;

import app.service.ProductService;
import app.utils.InputHandler;

public class ConsoleApp {
    private final ProductService productService ;
    private final InputHandler input ;

    public ConsoleApp(ProductService productService, InputHandler inputHandler) {
        this.productService = productService;
        this.input = inputHandler;
    }


    public void run() {
        while (true) {
            showMenu();
            int choice = input.getInt("Input Choice : ");
            switch (choice) {
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input Tidak Valid");
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("--- Customer App ---");
        System.out.println("1. Create");
        System.out.println("2. Get All");
        System.out.println("3. Get By Id");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("6. Exit");
        System.out.println("--------------------");
    }
}
