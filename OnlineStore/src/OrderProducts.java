import java.io.Serializable;

public class OrderProducts implements Serializable
{
    private final Integer productId;
    private final Double priceOfProduct;
    private final Integer quantity;

    public OrderProducts(Integer productId, Double priceOfProduct, Integer quantity)
    {
        this.productId = productId;
        this.priceOfProduct = priceOfProduct;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public Double getPriceOfProduct() {
        return priceOfProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
