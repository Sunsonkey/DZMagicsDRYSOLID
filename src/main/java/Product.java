public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private Category category;

    public Product(String id, String name, String description, double price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Продукт{" +
                "id='" + id + '\'' +
                ", Наименование='" + name + '\'' +
                ", Описание='" + description + '\'' +
                ", Цена=" + price +
                ", Категория=" + category +
                '}';
    }
}
