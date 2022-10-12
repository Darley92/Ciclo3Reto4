package com.example.ciclo3_reto3.entities.custom;

public class StatusReservation {

    private int completed;
    private int cancelled;

    public StatusReservation(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}
