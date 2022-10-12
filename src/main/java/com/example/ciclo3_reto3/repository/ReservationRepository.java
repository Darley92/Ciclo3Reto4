package com.example.ciclo3_reto3.repository;



import com.example.ciclo3_reto3.entities.Client;
import com.example.ciclo3_reto3.entities.Reservation;
import com.example.ciclo3_reto3.entities.custom.CountClient;
import com.example.ciclo3_reto3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation> getAll(){return (List<Reservation>) reservationCrudRepository.findAll();}
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public List<CountClient> getTopClient(){
        List<CountClient> res= new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            /*
            Client c = (Client) report.get(i)[0];
            Integer cant= (Integer) report.get(i)[1];
            CountClient cc=new CountClient(cant,c);
            res.add(cc);
            */
            res.add(new CountClient((Long) report.get(i)[1],(Client) report.get(i)[0]));
        }

        return res;
    }

}
