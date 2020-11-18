package am.bdgjpasping.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by User on 17.09.2020.
 */
@Entity
@Table(name = "addressEntity")
@Data
@Setter
@Getter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;


 //   @OneToMany(mappedBy = "addressEntity", fetch = FetchType.EAGER)

   @OneToMany(mappedBy = "addressEntity", fetch = FetchType.LAZY)
    private Set<PassengerEntity> passengerEntities;

    public AddressEntity(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public AddressEntity(String country, String city, Set<PassengerEntity> passengerEntities) {
        this.country = country;
        this.city = city;
        this.passengerEntities = passengerEntities;
    }

    public AddressEntity() {
    }
}
