import com.sun.source.tree.CaseTree;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int choice = -1;
        try {
            Scanner in = new Scanner(System.in);
            OnlineStoreManagement management = new OnlineStoreManagement();
            while (choice != 0)
            {
                System.out.println("1. Add client\n2. Add product\n3. Make order\n0. Exit");
                choice = in.nextInt();
                switch (choice)
                {
                    case 1->management.addClient();
                    case 2->management.addProduct();
                    case 3->management.makeOrder();
                    case 0->management.write();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
