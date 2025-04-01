import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class InMemoryDataStorage implements DataStorage {
    private final Map<String, Product> products = new HashMap<>();
    private final Map<String, Category> categories = new HashMap<>();

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(String id) {
        return products.get(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    @Override
    public Category getCategoryById(String id) {
        return categories.get(id);
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        if (products.containsKey(product.getId())) {
            products.put(product.getId(), product);
        } else {
            System.out.println("Продукт с ID " + product.getId() + " не найден для обновления.");
        }
    }

    @Override
    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Продукт с ID " + productId + " не найден для удаления.");
        }
    }

    @Override
    public void addCategory(Category category) {
        categories.put(category.getId(), category);
    }

    @Override
    public void updateCategory(Category category) {
        if (categories.containsKey(category.getId())) {
            categories.put(category.getId(), category);
        } else {
            System.out.println("Категория с ID " + category.getId() + " не найдена для обновления.");
        }
    }

    @Override
    public void deleteCategory(String categoryId) {
        if (categories.containsKey(categoryId)) {
            categories.remove(categoryId);
        } else {
            System.out.println("Категория с ID " + categoryId + " не найдена для удаления.");
        }
    }


    //TODO
    // Методы для работы с пользователями и заказами (будут добавлены позже)
}