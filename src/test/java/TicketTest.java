import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test

    public void ticketTest() {

        Ticket ticket1 = new Ticket("Москва", "Казань", 20_000, 12_00, 14_00);
        Ticket ticket2 = new Ticket("Казань", "Саратов", 15_000, 15_00, 16_00);
        Ticket ticket3 = new Ticket("Саратов", "Москва", 25_000, 11_00, 13_00);

        System.out.println("Тест сравнения билетов по цене:");
        System.out.println(ticket1.compareTo(ticket2)); // Ожидаемый вывод: 1 (ticket1 is more expensive than ticket2)
        System.out.println(ticket2.compareTo(ticket1)); // Ожидаемый вывод: -1 (ticket2 is cheaper than ticket1)
        System.out.println(ticket1.compareTo(ticket3)); // Ожидаемый вывод: -1 (ticket1 is cheaper than ticket3)
        System.out.println(ticket2.compareTo(ticket3)); // Ожидаемый вывод: -1 (ticket2 is cheaper than ticket3)
        System.out.println(ticket3.compareTo(ticket3)); // Ожидаемый вывод: 0 (ticket3 has the same price as ticket3)

        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        System.out.println("Тест сортировки билетов по цене:");
        Ticket[] sortedTickets = manager.findAll();
        Arrays.sort(sortedTickets); // Сортировка по цене (с помощью метода compareTo)
        for (Ticket ticket : sortedTickets) {
            System.out.println(ticket.getFrom() + " -> " + ticket.getTo() + ", Цена: " + ticket.getPrice());
        }

    }
}