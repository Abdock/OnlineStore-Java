import java.io.Serializable;

public abstract class DeliverySystem implements Serializable
{
    protected Integer orderId;
    protected Integer clientId;
    private static int count = 0;
    protected Integer invoiceNumber;

    public DeliverySystem(Integer orderId, Integer clientId) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.invoiceNumber = count++;
    }

    public abstract void delivery();

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }
}
