import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        System.out.println("Билеты, осортированные по цене :");

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

    @Test

    public void ticketTimeComparatorTest(){

        Ticket ticket1 = new Ticket("Москва", "Казань", 20_000, 12_00, 14_00);
        Ticket ticket2 = new Ticket("Казань", "Саратов", 15_000, 15_00, 16_00);
        Ticket ticket3 = new Ticket("Саратов", "Москва", 25_000, 11_00, 14_00);


        Ticket[] tickets = { ticket1, ticket2, ticket3};

        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Arrays.sort(tickets, timeComparator);

        System.out.println();
        System.out.println("Билеты, отсортированные по продолжительности полета:");
        for (Ticket ticket : tickets) {
            int duration = ticket.getTimeTo() - ticket.getTimeFrom();
            System.out.println(ticket.getFrom() + " -> " + ticket.getTo() + " | Длительность полета: " + duration + " мин");
        }


    }
}