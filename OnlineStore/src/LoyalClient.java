public class LoyalClient extends Client {
    private Integer discount;
    private Double cashback;

    public LoyalClient(Integer id, String name, String surname, Integer discount, Double cashback) {
        super(id, name, surname);
        this.discount = discount;
        this.cashback = cashback;
    }

    @Override
    public double buy(Order order)
    {
        payCounts++;
        return (order.getTotalPrice() * 90.0) / 100.0;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Double getCashback() {
        return cashback;
    }

    @Override
    public String toString()
    {
        return "Loyal client name: " + name + " surname: " + surname;
    }
}
