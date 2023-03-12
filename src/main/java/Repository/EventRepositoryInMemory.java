package Repository;

import lombok.NonNull;
import model.Event;

import java.util.Locale;
import java.util.Map;

public class EventRepositoryInMemory implements IEventRepository {

private Map<String, Event> eventMap;

    @Override
    public void addEvent(@NonNull final Event event) {
        eventMap.put(event.getName().toLowerCase(Locale.ROOT),event);
    }

    @Override
    public Event getEvent(@NonNull final String eventId) {
        return eventMap.get(eventId);
    }
}
