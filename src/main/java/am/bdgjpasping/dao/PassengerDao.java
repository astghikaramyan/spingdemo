package am.bdgjpasping.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 12.11.2020.
 */
@Data
@EqualsAndHashCode
public class PassengerDao {

    private Long passengerId;

    private String name;

    private String phone;

    private AddressDao address;

    Set<TripDao> trips = new HashSet<>();

    public PassengerDao(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public PassengerDao(String name, String phone, AddressDao address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public PassengerDao() {
    }
}
