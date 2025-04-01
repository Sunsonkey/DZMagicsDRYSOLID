public class Main {
    public static void main(String[] args) {

        DataStorage dataStorage = new InMemoryDataStorage();

        Category electronics = new Category("1", "Электроника");
        Category books = new Category("2", "Книги");
        dataStorage.addCategory(electronics);
        dataStorage.addCategory(books);

        Product product1 = new Product("1", "Ноутбук", "Мощный ноутбук для работы и игр", 1200.00, electronics);
        Product product2 = new Product("2", "Наушники", "Наушники с функцией шумоподавления", 200.00, electronics);
        Product product3 = new Product("3", "Властелин колец", "Классический роман в жанре фантастика", 25.00, books);
        dataStorage.addProduct(product1);
        dataStorage.addProduct(product2);
        dataStorage.addProduct(product3);


        ProductCatalog productCatalog = new ProductCatalog(dataStorage);

        ConsoleInterface consoleInterface = new ConsoleInterface(productCatalog);

        consoleInterface.start();

//        consoleInterface.placeOrder();
    }
}