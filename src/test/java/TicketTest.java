import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test

    public void ticketCompareToTest() {

        Ticket ticket1 = new Ticket("Москва", "Казань", 20_000, 12_00, 14_00);
        Ticket ticket2 = new Ticket("Казань", "Саратов", 15_000, 15_00, 16_00);
        Ticket ticket3 = new Ticket("Саратов", "Москва", 25_000, 11_00, 13_00);


        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] sortedTickets = manager.findAll();
        Arrays.sort(sortedTickets);
        System.out.println();
        System.out.println("Список :");

        for (Ticket ticket : sortedTickets) {
            System.out.println(ticket.getFrom() + " -> " + ticket.getTo() + ", Цена: " + ticket.getPrice());
        }

    }

    @Test

    public void ticketSearchTest () {

        Ticket ticket1 = new Ticket("Москва", "Казань", 20_000, 12_00, 14_00);
        Ticket ticket2 = new Ticket("Казань", "Саратов", 15_000, 15_00, 16_00);
        Ticket ticket3 = new Ticket("Саратов", "Москва", 25_000, 11_00, 13_00);


        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] searchResult = manager.search("Казань", "Саратов");
        System.out.println();
        System.out.println("Поиск:");

        for (Ticket ticket : searchResult) {
            System.out.println(ticket.getFrom() + " -> " + ticket.getTo() + ", Цена: " + ticket.getPrice());
        }
    }
}