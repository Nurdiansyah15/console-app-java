package app.utils;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public InputHandler() {

    }

    public String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public int getInt(String message) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka");
            scanner.next();
            System.out.println(message);
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
}
