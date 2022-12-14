package com.example.ciclo3_reto3.controller;

import com.example.ciclo3_reto3.entities.Machine;
import com.example.ciclo3_reto3.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<Machine> getMachine(){
        return machineService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Machine> getMachine(@PathVariable("id") int machineId) {
        return machineService.getMachine(machineId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine machine){
        return machineService.save(machine);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine) {
        return machineService.update(machine);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return machineService.deleteMachine(id);
    }


}

