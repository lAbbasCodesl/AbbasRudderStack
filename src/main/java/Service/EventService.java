package Service;

import Repository.IEventRepository;
import lombok.AllArgsConstructor;
import model.Event;

@AllArgsConstructor
public class EventService {
    private IEventRepository eventRepository;

    public Event getEvent(String eventId){
       return eventRepository.getEvent(eventId);
    }

    public void addEvent(Event event){
        eventRepository.addEvent(event);
    }
}
