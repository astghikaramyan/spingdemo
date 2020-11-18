package am.bdgjpasping.service.serviceimpl;

import am.bdgjpasping.entity.PassengerEntity;
import am.bdgjpasping.repository.PassengerRepo;
import am.bdgjpasping.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by User on 17.09.2020.
 */
@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepo passengerRepo;

    @Autowired
    public PassengerServiceImpl(PassengerRepo passengerRepo) {
        this.passengerRepo = passengerRepo;
    }

    @Override
    public Optional<PassengerEntity> getById(long id){
        Optional<PassengerEntity> passenger = passengerRepo.findById(id);
        return passenger;
    }

    @Override
    public Set<PassengerEntity> getAll(){
        List<PassengerEntity> passengerEntities = passengerRepo.findAll();
        if(passengerEntities != null){
            Set<PassengerEntity> passengers1 = new HashSet<>();
            for(PassengerEntity p : passengerEntities){
                passengers1.add(p);
            }
            return passengers1;
        }
        return null;
    }
    @Override
    public Set<PassengerEntity> get(int page, int perPage, String sort){
        Set<PassengerEntity> passengerEntities = new LinkedHashSet<>();
        Page<PassengerEntity> passengerPage = this.passengerRepo.
                findAll(PageRequest.of(page, perPage, Sort.sort(sort.getClass())));
        for(PassengerEntity p : passengerPage){
            passengerEntities.add(p);
        }
        return passengerEntities;
    }

    @Override
    public PassengerEntity save(PassengerEntity passengerEntity){
            return passengerRepo.save(passengerEntity);
    }

    @Override
    public PassengerEntity update(PassengerEntity passengerEntity) {
            return passengerRepo.save(passengerEntity);
    }

    @Override
    public void delete(long passengerId){
        Optional<PassengerEntity> passenger = passengerRepo.findById(passengerId);
        if(passenger.isPresent()){
            passengerRepo.delete(passenger.get());
        }
    }
}
