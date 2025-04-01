import java.util.List;

//Open-Closed principle - Интерфейс DataStorage позволяет нам легко добавлять новые способы хранения данных
//без изменения кода, который использует DataStorage (к примеру, ProductCatalog)
public interface DataStorage {
    List<Product> getAllProducts();
    Product getProductById(String id);
    List<Category> getAllCategories();
    Category getCategoryById(String id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(String productId);
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(String categoryId);

    // Методы для работы с пользователями и заказами (будут добавлены позже)
}

//Interface segregation principle - Вместо одного большого интерфейса DataStorage,
// можно разделить его на несколько маленьких интерфейсов,
// например ProductStorage, CategoryStorage, UserStorage