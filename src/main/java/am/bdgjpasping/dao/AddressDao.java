package am.bdgjpasping.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by User on 12.11.2020.
 */
@Data
@EqualsAndHashCode
public class AddressDao {

    private Long addressId;

    private String country;


    private String city;


    private Set<PassengerDao> passengers;

    public AddressDao(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public AddressDao(String country, String city, Set<PassengerDao> passengers) {
        this.country = country;
        this.city = city;
        this.passengers = passengers;
    }

    public AddressDao() {
    }
}
