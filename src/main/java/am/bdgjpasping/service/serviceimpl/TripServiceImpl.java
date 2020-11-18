package am.bdgjpasping.service.serviceimpl;


import am.bdgjpasping.entity.PassengerEntity;
import am.bdgjpasping.entity.TripEntity;
import am.bdgjpasping.repository.TripRepo;
import am.bdgjpasping.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by User on 17.09.2020.
 */
@Service
public class TripServiceImpl implements TripService {

    private final TripRepo tripRepo;

    @Autowired
    public TripServiceImpl(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }

    @Override
    public Optional<TripEntity> getById(long id) {

        return tripRepo.findById(id);
    }

    @Override
    public Set<TripEntity> getAll(){
        List<TripEntity> tripes = tripRepo.findAll();
        if(tripes != null){
            Set<TripEntity> tripes1 = new HashSet<>();
            for(TripEntity p : tripes){
                tripes1.add(p);
            }
            return tripes1;
        }
        return null;
    }

    @Override
    public Set<TripEntity> get(int page, int perPage, String sort){
        Set<TripEntity> tripEntities = new LinkedHashSet<>();
        Page<TripEntity> passengerPage = this.tripRepo.
                findAll(PageRequest.of(page, perPage, Sort.sort(sort.getClass())));
        for(TripEntity p : passengerPage){
            tripEntities.add(p);
        }
        return tripEntities;
    }

    @Override
    public TripEntity save(TripEntity tripEntity){
            return tripRepo.save(tripEntity);
    }

    @Override
    public TripEntity update(TripEntity tripEntity) {
            return tripRepo.save(tripEntity);
    }

    @Override
    public void delete(long tripId){

        Optional<TripEntity> trip = tripRepo.findById(tripId);
        if(trip.isPresent()){
            tripRepo.delete(trip.get());
        }
        tripRepo.delete(trip.get());
    }

    @Override
    public List<TripEntity> getTripsFrom(String city) {
         List<TripEntity> tripEntities = tripRepo.getTripByFromCity(city);
         if(tripEntities != null){
             return tripEntities;
         }
         return null;
    }

    @Override
    public List<TripEntity> getTripsTo(String city) {
        List<TripEntity> tripEntities = tripRepo.getTripByToCity(city);
        if(tripEntities != null){
            return tripEntities;
        }
        return null;
    }

    @Override
    public Set<PassengerEntity> getPassengersOfTrip(long tripNumber) throws SQLException {
        Set<PassengerEntity> passengerEntities = new HashSet<>();
        TripEntity trips = tripRepo.getTripByTripNumber(tripNumber);
        passengerEntities = trips.getPassengerEntities();
        if(passengerEntities != null){
            return passengerEntities;
        }
        return null;
    }
//
//    @Override
//    public void registerTrip(TripEntity trip, PassengerEntity passenger) throws SQLException {
//
//    }
//
//    @Override
//    public void cancelTrip(long passengerId, long tripNumber) throws SQLException {
//
//    }
}
