import java.io.Serializable;
import java.util.ArrayList;

public abstract class Client implements Serializable
{
    protected Integer id;
    protected String name;
    protected String surname;
    protected ArrayList<Order> orders;
    protected int payCounts = 0;

    public Client(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        orders = new ArrayList<>();
    }

    public int getPayCounts() {
        return payCounts;
    }

    public abstract double buy(Order order);

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
