package com.example.ciclo3_reto3.repository;

import com.example.ciclo3_reto3.entities.Machine;
import com.example.ciclo3_reto3.repository.crudRepository.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MachineRepository {

    @Autowired
    private MachineCrudRepository machineCrudRepository;

    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }
    public Optional<Machine> getMachine(int id){
        return machineCrudRepository.findById(id);
    }
    public Machine save(Machine machine){
        return machineCrudRepository.save(machine);
    }
    public void delete(Machine machine){
        machineCrudRepository.delete(machine);
    }
}
