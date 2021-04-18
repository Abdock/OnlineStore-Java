import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class Payment implements Serializable
{
    private static int count = 0;
    private final Integer id;
    private Integer clientId;
    private Integer orderId;
    private final Date date;
    private boolean status;
    private Double orderTotalPrice;

    public Payment() {
        id = count++;
        this.date = new Date();
        this.status = false;
    }

    public void calculatePayment(Client client, Order order)
    {
        Scanner in = new Scanner(System.in);
        clientId = client.getId();
        orderId = order.getId();
        orderTotalPrice = client.buy(order);
        System.out.println("Total price: " + orderTotalPrice + " please enter money");
        double money = in.nextDouble();
        while (money < orderTotalPrice)
        {
            System.out.println("Not enough money");
            money += in.nextDouble();
        }
        System.out.println("Your change: " + (money - orderTotalPrice) + ((client instanceof LoyalClient) ? " and cashback " + orderTotalPrice * 0.1 : ""));
    }

    public static int getCount() {
        return count;
    }

    public Integer getId() {
        return id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }
}
