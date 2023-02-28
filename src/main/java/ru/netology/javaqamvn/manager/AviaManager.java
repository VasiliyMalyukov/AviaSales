package ru.netology.javaqamvn.manager;

import ru.netology.javaqamvn.domain.AviaSales;
import ru.netology.javaqamvn.repository.AviaRepo;

import java.util.Arrays;

public class AviaManager {
    private final AviaRepo repository;

    public AviaManager(AviaRepo repository) {
        this.repository = repository;
    }

    public AviaSales[] findAll(String from, String to) {
        AviaSales[] result = new AviaSales[0];
        for (AviaSales ticket : repository.findAll()) {
            if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)) {
                AviaSales[] tmp = new AviaSales[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}