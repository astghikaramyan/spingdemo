package am.bdgjpasping.controller;



import am.bdgjpasping.dao.AddressDao;
import am.bdgjpasping.entity.AddressEntity;
import am.bdgjpasping.mapper.AddressMapper;
import am.bdgjpasping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 20.09.2020.
 */
@RestController
@RequestMapping("addresses")
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressController(AddressService addressService,AddressMapper addressMapper){
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }


    @PostMapping
    public ResponseEntity<AddressDao> addAddress(@RequestBody AddressDao addressDao) throws SQLException {
        AddressEntity addressEntityEntity = this.addressMapper.toEntity(addressDao);
        addressEntityEntity = this.addressService.save(addressEntityEntity);
        return ResponseEntity.ok(this.addressMapper.toDto(addressEntityEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDao> getAddress(@PathVariable Long id) throws SQLException {
        Optional<AddressEntity> addressEntity = this.addressService.getById(id);
        if (addressEntity.isPresent()) {
            return ResponseEntity.ok(this.addressMapper.toDto(addressEntity.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws SQLException {
        this.addressService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDao> updateAddress(@RequestBody AddressDao addressDao, @PathVariable Long id) throws SQLException {
        AddressEntity addressEntityEntity = this.addressMapper.toEntity(addressDao);
        addressEntityEntity.setAddressId(id);
        addressEntityEntity = this.addressService.save(addressEntityEntity);
        return ResponseEntity.ok(this.addressMapper.toDto(addressEntityEntity));
    }

    @GetMapping
    public ResponseEntity<Set<AddressDao>> getAddresses() throws SQLException {
        Set<AddressEntity> addressEntityEntity = this.addressService.getAll();
        if(addressEntityEntity != null){
            return ResponseEntity.ok(this.addressMapper.toDtoSet(addressEntityEntity));
        }
        return ResponseEntity.notFound().build();
    }
}
