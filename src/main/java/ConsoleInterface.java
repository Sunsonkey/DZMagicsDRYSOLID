import java.util.List;
import java.util.Scanner;


//DRY - displayMenu, getUserChoice выделены в отдельные методы, чтобы избежать дублирования кода.
public class ConsoleInterface {

    private final ProductCatalog productCatalog;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleInterface(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    searchProducts();
                    break;
                case 3:
                    placeOrder();
                    break;
                case 0:
                    System.out.println("Спасибо за посещение!");
                    return;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nДобро пожаловать в наш магазин!");
        System.out.println("1. Каталог товаров");
        System.out.println("2. Поиск товаров");
        System.out.println("3. Выбор способа доставки");
        System.out.println("0. Выход");
        System.out.println("Выберите действие:");
    }

    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void displayAllProducts() {
        List<Product> products = productCatalog.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Каталог товаров пуст.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private void searchProducts() {
        System.out.println("Введите ключевое слово для поиска:");
        String keyword = scanner.nextLine();
        List<Product> products = productCatalog.searchProducts(keyword);
        if (products.isEmpty()) {
            System.out.println("Товары не найдены.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите способ доставки:");
        System.out.println("1. Курьер");
        System.out.println("2. Самовывоз");
        int deliveryChoice = getUserChoice();

        DeliveryMethod deliveryMethod;
        if (deliveryChoice == 1) {
            deliveryMethod = new CourierDelivery();
        } else if (deliveryChoice == 2) {
            deliveryMethod = new PickupDelivery();
        } else {
            System.out.println("Неверный выбор способа доставки.");
            return;
        }

        System.out.println("Введите вес заказа (кг):");
        double orderWeight = Double.parseDouble(scanner.nextLine()); // Предполагаем ввод пользователя

        Order order = new Order(deliveryMethod, orderWeight);
        System.out.println("Способ доставки: " + order.getDeliveryDescription());
        System.out.println("Стоимость доставки: " + order.calculateTotalCost());
        System.out.println("Заказ оформлен.");
    }
}
