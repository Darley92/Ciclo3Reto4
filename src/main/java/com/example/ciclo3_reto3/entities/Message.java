package com.example.ciclo3_reto3.entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;



@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Machine machine;
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }


}
