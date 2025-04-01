import java.util.List;
import java.util.stream.Collectors;

//Single-Responsibility principle - ProductCatalog отвечает только за управление каталогом товаров
// (получение, поиск, фильтрация), а не за взаимодействие с пользователем (ConsoleInterface) или хранение данных(DataStorage)

//Dependency inversion principle - Класс ProductCatalog зависит от абстракции DataStorage,
// а не от конкретной реализации (InMemoryDataStorage)
public class ProductCatalog {
    private final DataStorage dataStorage;

    public ProductCatalog(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public List<Product> getAllProducts() {
        return dataStorage.getAllProducts();
    }

    public Product getProductById(String id) {
        return dataStorage.getProductById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return dataStorage.getAllProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        product.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Product> filterProductsByCategory(String categoryId) {
        return dataStorage.getAllProducts().stream()
                .filter(product -> product.getCategory().getId().equals(categoryId))
                .collect(Collectors.toList());
    }
}