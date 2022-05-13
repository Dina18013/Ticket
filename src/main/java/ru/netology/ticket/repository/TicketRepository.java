package ru.netology.ticket.repository;

import ru.netology.ticket.data.Ticket;

public class TicketRepository {

    Ticket[] tickets = new Ticket[0];

    public TicketRepository() {
        this.tickets = tickets;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public void add(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        for (int i = 0; i < length - 1; i++) {
            tmp[i] = tickets[i];
        }
        tmp[length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return getTickets();
    }
}
