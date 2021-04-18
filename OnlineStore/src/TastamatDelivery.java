import java.util.ArrayList;
import java.util.Scanner;

public class TastamatDelivery extends DeliverySystem
{
    private ArrayList<Tastamat> listOfPostmats = new ArrayList<>();

    public TastamatDelivery(Integer orderId, Integer clientId) {
        super(orderId, clientId);
    }

    @Override
    public void delivery() {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < listOfPostmats.size(); ++i)
        {
            System.out.println(i + " " + listOfPostmats.get(i).toString());
        }
        System.out.println("Enter index of list");
        int index = in.nextInt();
        System.out.println("Success, you can give your order " + listOfPostmats.get(index).toString());
    }

    public ArrayList<Tastamat> getListOfPostmats() {
        return listOfPostmats;
    }
}
