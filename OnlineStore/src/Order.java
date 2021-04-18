import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable
{
    private final Integer id;
    private final Integer clientId;
    private final ArrayList<OrderProducts> productIds;
    private Double totalPrice;

    public Order(Integer id, Integer clientId)
    {
        this.id = id;
        this.clientId = clientId;
        totalPrice = 0.0;
        productIds = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity)
    {
        productIds.add(new OrderProducts(product.getId(), product.getPrice(), quantity));
        totalPrice += product.getPrice() * quantity;
    }

    public Integer getId() {
        return id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public ArrayList<OrderProducts> getProductIds() {
        return productIds;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
