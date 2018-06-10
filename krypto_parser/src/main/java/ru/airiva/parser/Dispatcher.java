package ru.airiva.parser;

import ru.airiva.tdlib.Client;
import ru.airiva.tdlib.TdApi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Ivan
 */
public class Dispatcher {

    private final Map<Long, Set<Courier>> courierMap;

    public Dispatcher() {
        this.courierMap = new HashMap<>();
    }

    public synchronized void dispatch(final TdApi.Message message, final Client client) {
        if (message.content.getConstructor() == TdApi.MessageText.CONSTRUCTOR) {
            final String text = ((TdApi.MessageText) message.content).text.text;
            synchronized (courierMap) {
                Set<Courier> couriers = courierMap.get(message.chatId);
                if (couriers != null) {
                    couriers.forEach(courier -> courier.send(text, client));
                }
            }
        }
    }

    public void putCourier(Courier courier) {
        if (courier != null) {
            synchronized (courierMap) {
                Set<Courier> couriers = courierMap.get(courier.source);
                if (couriers != null) {
                    couriers.add(courier);
                } else {
                    couriers = new HashSet<>();
                    couriers.add(courier);
                    courierMap.put(courier.source, couriers);
                }
            }
        }
    }

    public void deleteCourier(Courier courier) {
        if (courier != null) {
            synchronized (courierMap) {
                Set<Courier> couriers = courierMap.get(courier.source);
                if (couriers != null) {
                    couriers.remove(courier);
                }
            }
        }
    }

}
