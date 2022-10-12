package com.example.ciclo3_reto3.controller;


import com.example.ciclo3_reto3.entities.Reservation;
import com.example.ciclo3_reto3.entities.custom.CountClient;
import com.example.ciclo3_reto3.entities.custom.StatusReservation;
import com.example.ciclo3_reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return reservationService.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    //Reto 5

    @GetMapping("/report-status")
    public StatusReservation getReservationStatus(){
        return reservationService.getStatusReport();
    }
    @GetMapping("/report-clients")
        public List<CountClient> getCountClient(){
            return reservationService.getTopClient();
        }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable ("dateOne")String d1, @PathVariable ("dateTwo")String d2){
        return reservationService.getReservationPeriod(d1,d2);
    }


}
