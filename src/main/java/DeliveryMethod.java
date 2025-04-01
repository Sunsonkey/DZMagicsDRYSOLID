//Liskov Substitution Principle - CourierDelivery, DeliveryMethod имплементируют DeliveryMethod,
// а не наследуют один другого, не смотря на то, что как бы утки
public interface DeliveryMethod {
    String getDescription(); // Описание способа доставки
    double calculateCost(double orderWeight); // Расчет стоимости доставки
}