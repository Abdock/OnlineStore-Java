public class OrdinaryClient extends Client {
    public OrdinaryClient(Integer id, String name, String surname) {
        super(id, name, surname);
    }

    @Override
    public double buy(Order order)
    {
        payCounts++;
        return order.getTotalPrice();
    }

    @Override
    public String toString()
    {
        return "Ordinary client name: " + name + " surname: " + surname;
    }
}
