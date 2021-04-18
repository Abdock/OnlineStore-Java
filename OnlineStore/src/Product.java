import java.io.Serializable;

public class Product implements Serializable
{
    private final Integer id;
    private final String name;
    private final Double price;
    private final Integer amountOfStock;

    public Product(Integer id, String name, Double price, Integer amountOfStock)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amountOfStock = amountOfStock;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAmountOfStock() {
        return amountOfStock;
    }

    @Override
    public String toString()
    {
        return "Product name: " + name + " price: " + price + " amount of stock: " + amountOfStock;
    }
}
