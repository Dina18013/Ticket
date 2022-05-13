package ru.netology.ticket.manager;

import ru.netology.ticket.data.Ticket;

import ru.netology.ticket.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    TicketRepository repository = new TicketRepository();

    public TicketManager() {
    }

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketRepository getRepository() {
        return repository;
    }

    public void setRepository(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.add(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] results = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[results.length + 1];
                for (int i = 0; i < results.length; i++) {
                    tmp[i] = results[i];
                }
                tmp[tmp.length - 1] = ticket;
                results = tmp;
            }
        }
        Arrays.sort(results);
        return results;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom() != from) {
            return false;
        }
        if (ticket.getTo() != to) {
            return false;
        }
        return true;

    }
}
