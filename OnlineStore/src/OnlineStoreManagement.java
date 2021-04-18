import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStoreManagement
{
    private ArrayList<Product> products;
    private ArrayList<Client> clients;
    private ArrayList<Order> orders;
    private ArrayList<Payment> receipts;
    private ArrayList<DeliverySystem> deliverySystems;
    private Scanner in = new Scanner(System.in);

    public OnlineStoreManagement() throws IOException
    {
        try
        {
            ObjectInputStream product = new ObjectInputStream(new FileInputStream("Products.txt"));
            products = (ArrayList<Product>)product.readObject();
        }
        catch (FileNotFoundException | ClassNotFoundException e)
        {
            products = new ArrayList<>();
        }
        try
        {
            ObjectInputStream client = new ObjectInputStream(new FileInputStream("Clients.txt"));
            clients = (ArrayList<Client>)client.readObject();
        }
        catch (FileNotFoundException | ClassNotFoundException e)
        {
            clients = new ArrayList<>();
        }
        try
        {
            ObjectInputStream order = new ObjectInputStream(new FileInputStream("Orders.txt"));
            orders = (ArrayList<Order>)order.readObject();
        }
        catch (FileNotFoundException | ClassNotFoundException e)
        {
            orders = new ArrayList<>();
        }
        try
        {
            ObjectInputStream receipt = new ObjectInputStream(new FileInputStream("Receipts.txt"));
            receipts = (ArrayList<Payment>)receipt.readObject();
        }
        catch (FileNotFoundException | ClassNotFoundException e)
        {
            receipts = new ArrayList<>();
        }
    }

    private TastamatDelivery readDelivery(int orderId, int clientId)
    {
        TastamatDelivery delivery = new TastamatDelivery(orderId, clientId);
        File file = new File("Tastamat.txt");
        try
        {
            Scanner read = new Scanner(file);
            while (read.hasNextLine())
            {
                String[] line = read.nextLine().split(";");
                Integer index = Integer.parseInt(line[0]);
                String city = line[1];
                String location = line[2];
                delivery.getListOfPostmats().add(new Tastamat(index, city, location));
            }
            return delivery;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void delivery(int orderId, int clientId)
    {
        System.out.println("1. Direct delivery\n2. Tastamat delivery");
        DeliverySystem system;
        int choice = in.nextInt();
        if(choice == 1)
        {
            System.out.println("Enter city");
            String city = in.next();
            System.out.println("Enter street name");
            String street = in.next();
            System.out.println("Enter house number");
            Integer house = in.nextInt();
            System.out.println("Enter flat number");
            Integer flat = in.nextInt();
            system = new DirectDelivery(orderId, clientId, city, street, house, flat);
        }
        else
        {
            system = readDelivery(orderId, clientId);
        }
        system.delivery();
    }

    public void addClient()
    {
        System.out.println("Client name");
        String name = in.next();
        System.out.println("Client surname");
        String surname = in.next();
        clients.add(new OrdinaryClient(clients.size(), name, surname));
    }

    public Client chooseClient()
    {
        for(int i = 0; i < clients.size(); ++i)
        {
            System.out.println(i + " " + clients.get(i).toString());
        }
        System.out.println("Please enter position of list");
        int index = in.nextInt();
        return clients.get(index);
    }

    public void addProduct()
    {
        System.out.println("Product name");
        String name = in.next();
        System.out.println("Product price");
        double price = in.nextDouble();
        System.out.println("Product amount");
        int amount = in.nextInt();
        products.add(new Product(products.size(), name, price, amount));
    }

    public void makeOrder()
    {
        if(products.isEmpty())
        {
            System.out.println("Product list is empty, please enter some products");
        }
        else
        {
            Client client = chooseClient();
            Order order = new Order(orders.size(), client.getId());
            int choice = -1;
            do {
                for (int i = 0; i < products.size(); ++i) {
                    System.out.println(i + " " + products.get(i).toString());
                }
                System.out.println("Enter index of list");
                int index = in.nextInt();
                System.out.println("Enter quantity");
                int quantity = in.nextInt();
                while(quantity < 0)
                {
                    System.out.println("Please enter correct quantity");
                    quantity = in.nextInt();
                }
                if (quantity <= products.get(index).getAmountOfStock()) {
                    order.addProduct(products.get(index), quantity);
                } else {
                    System.out.println("Sorry not enough products");
                }
                System.out.println("1. Continue\n2. Complete");
                choice = in.nextInt();
                while (choice != 1 && choice != 2) {
                    System.out.println("Enter correct data");
                    choice = in.nextInt();
                }
            } while (choice != 2);
            Payment payment = new Payment();
            payment.calculatePayment(client, order);
            client.getOrders().add(order);
            if(client instanceof OrdinaryClient && client.getOrders().size() >= 5)
            {
                Client newClient = new PrimeClient(client.getId(), client.getName(), client.getSurname(), 5);
                newClient.setOrders(client.getOrders());
                clients.remove(client);
                clients.add(newClient);
                client = newClient;
            }
            else if(client instanceof PrimeClient && client.getOrders().size() >= 10)
            {
                Client newClient = new LoyalClient(client.getId(), client.getName(), client.getSurname(), 10, 10.0);
                newClient.setOrders(client.getOrders());
                clients.remove(client);
                clients.add(newClient);
                client = newClient;
            }
            orders.add(order);
            receipts.add(payment);
            delivery(order.getId(), client.getId());
        }
    }

    public void write() throws IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("Products.txt"));
        writer.writeObject(products);
        writer = new ObjectOutputStream(new FileOutputStream("Clients.txt"));
        writer.writeObject(clients);
        writer = new ObjectOutputStream(new FileOutputStream("Orders.txt"));
        writer.writeObject(orders);
        writer = new ObjectOutputStream(new FileOutputStream("Receipts.txt"));
        writer.writeObject(receipts);
        for(var item : receipts)
        {
            item.setStatus(true);
        }
    }
}
