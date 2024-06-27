import app.ConsoleApp;
import app.model.Product;
import app.service.FileProductService;
import app.service.ProductService;
import app.utils.FileHandler;
import app.utils.InputHandler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("src/app/data.csv");
        ProductService service = new FileProductService(fileHandler);
        InputHandler input = new InputHandler();
        new ConsoleApp(service, input).run();
    }
}
