public class PrimeClient extends Client
{
    private Integer discount;

    public PrimeClient(Integer id, String name, String surname, Integer discount) {
        super(id, name, surname);
        this.discount = discount;
    }

    @Override
    public double buy(Order order)
    {
        payCounts++;
        return order.getTotalPrice() * ((100.0 - (double)discount) / 100.0);
    }

    public Integer getDiscount() {
        return discount;
    }

    @Override
    public String toString()
    {
        return "Prime client name: " + name + " surname: " + surname;
    }
}
