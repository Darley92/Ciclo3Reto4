package com.example.ciclo3_reto3.repository.crudRepository;

import com.example.ciclo3_reto3.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    ///JPQL
    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by count (c.client) desc ")
    public List<Object[]> countTotalReservationByClient();
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation> findAllByStatus(String status);


}
