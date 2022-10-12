package com.example.ciclo3_reto3.service;



import com.example.ciclo3_reto3.entities.Reservation;
import com.example.ciclo3_reto3.entities.custom.CountClient;
import com.example.ciclo3_reto3.entities.custom.StatusReservation;
import com.example.ciclo3_reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if (e.isPresent()) {
                return reservation;
            } else {
                return reservationRepository.save(reservation);
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean deleteReservation(int id){
        boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;

    }

    public List<CountClient> getTopClient(){
        return reservationRepository.getTopClient();
    }

    public StatusReservation getStatusReport(){
        List<Reservation> completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled=reservationRepository.getReservationByStatus("cancelled");

        StatusReservation statusReservation= new StatusReservation(completed.size(),cancelled.size());
        return statusReservation;

    }

    public List<Reservation> getReservationPeriod(String d1,String d2){
        /// YYYY-MM-DD
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne= new Date();
        Date dateTwo= new Date();

        try {
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);


        }catch (ParseException e){
            e.printStackTrace();
        }

        if(dateOne.before(dateTwo)){

            return reservationRepository.getReservationPeriod(dateOne, dateTwo);

        }else{
            return new ArrayList<>();
        }

    }




}
