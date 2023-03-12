package Repository;


import lombok.NonNull;
import model.Event;

public interface IEventRepository {

    void addEvent(@NonNull final Event event);
    Event getEvent(@NonNull final String eventId);
}
