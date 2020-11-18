package am.bdgjpasping.service.serviceimpl;

import am.bdgjpasping.entity.AddressEntity;
import am.bdgjpasping.repository.AddressRepo;
import am.bdgjpasping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 20.09.2020.
 */
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    @Autowired
    public AddressServiceImpl(AddressRepo addressRepo){
        this.addressRepo = addressRepo;
    }

    @Override
    public Optional<AddressEntity> getById(long id) throws SQLException {
        return this.addressRepo.findById(id);
    }

    @Override
    public Set<AddressEntity> getAll() throws SQLException {
        Set<AddressEntity> addressEntities = new HashSet<>();
        List<AddressEntity> addressEntityList = this.addressRepo.findAll();
        if(addressEntityList != null){
            for(AddressEntity e : addressEntityList){
                addressEntities.add(e);
            }
            return addressEntities;
        }

        return null;
    }

    @Override
    public AddressEntity save(AddressEntity addressEntity) throws SQLException{
            return addressRepo.save(addressEntity);
    }

    @Override
    public AddressEntity update(AddressEntity addressEntity) throws SQLException {
        return addressRepo.save(addressEntity);
    }

    @Override
    public void delete(long addressId) throws SQLException {
        Optional<AddressEntity> addressOptional = addressRepo.findById(addressId);
        if(addressOptional.isPresent()){
            addressRepo.delete(addressOptional.get());
        }
    }
}
