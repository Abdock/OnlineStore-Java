import com.sun.net.httpserver.Authenticator;

import java.util.Scanner;

public class DirectDelivery extends DeliverySystem
{
    private String city;
    private String streetName;
    private Integer houseNumber;
    private Integer flatNumber;

    public DirectDelivery(Integer orderId, Integer clientId, String city, String streetName, Integer houseNumber, Integer flatNumber) {
        super(orderId, clientId);
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    @Override
    public void delivery()
    {
        System.out.println("Success");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }
}
