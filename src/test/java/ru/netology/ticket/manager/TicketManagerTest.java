package ru.netology.ticket.manager;

import org.junit.jupiter.api.Test;
import ru.netology.ticket.data.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {


    @Test
    void findAllForThreeTickets() {
        TicketManager manager = new TicketManager();
        Ticket ticket1 = new Ticket(1, 20_000, "DME", "LED", 60);
        Ticket ticket2 = new Ticket(2, 30_000, "DME", "LED", 120);
        Ticket ticket3 = new Ticket(3, 10_000, "DME", "LED", 100);
        Ticket[] expected = new Ticket[]{ticket3, ticket1, ticket2};
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll("DME", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllForSamePrice() {
        TicketManager manager = new TicketManager();
        Ticket ticket1 = new Ticket(1, 10_000, "DME", "LED", 60);
        Ticket ticket2 = new Ticket(2, 10_000, "DME", "LED", 120);
        Ticket ticket3 = new Ticket(3, 10_000, "DME", "LED", 100);
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3};
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll("DME", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllForOneResult() {
        TicketManager manager = new TicketManager();
        Ticket ticket1 = new Ticket(1, 10_000, "DME", "LED", 60);
        Ticket ticket2 = new Ticket(2, 10_000, "GOJ", "KUF", 120);
        Ticket[] expected = new Ticket[]{ticket2};
        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] actual = manager.findAll("GOJ", "KUF");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllForTwoResults() {
        TicketManager manager = new TicketManager();
        Ticket ticket1 = new Ticket(1, 20_000, "DME", "LED", 60);
        Ticket ticket2 = new Ticket(2, 30_000, "GOJ", "KUF", 120);
        Ticket ticket3 = new Ticket(3, 10_000, "DME", "LED", 100);
        Ticket[] expected = new Ticket[]{ticket3, ticket1};
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll("DME", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllNotResult() {
        TicketManager manager = new TicketManager();
        Ticket ticket1 = new Ticket(1, 10_000, "DME", "LED", 60);
        Ticket ticket2 = new Ticket(2, 10_000, "GOJ", "KUF", 120);
        Ticket[] expected = new Ticket[0];
        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] actual = manager.findAll("OGZ", "FRU");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllForIncorrectResult() {
        TicketManager manager = new TicketManager();
        Ticket ticket1 = new Ticket(1, 10_000, "DME", "LED", 60);
        Ticket ticket2 = new Ticket(2, 10_000, "GOJ", "KUF", 120);
        Ticket[] expected = new Ticket[0];
        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] actual = manager.findAll("GOJ", "LED");
        assertArrayEquals(expected, actual);
    }
}