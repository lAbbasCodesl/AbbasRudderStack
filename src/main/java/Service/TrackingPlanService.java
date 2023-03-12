package Service;

import Exceptions.TrackingPlanAlreadyExistsException;
import Exceptions.TrackingPlanNotFoundException;
import Repository.IEventRepository;
import Repository.ITrackingPlanRepository;
import lombok.AllArgsConstructor;
import model.Event;
import model.TrackingPlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@AllArgsConstructor
public class TrackingPlanService {

    private EventService eventService;
    private ITrackingPlanRepository trackingPlanRepository;

    public void addTrackingPlan(TrackingPlan trackingPlan, List<Event> events) throws TrackingPlanAlreadyExistsException {
        trackingPlanRepository.addTrackingPlan(trackingPlan);
        List<String> eventList = new ArrayList<>();
        for(Event event: events){
            eventList.add(event.getName());
            eventService.addEvent(event);
        }
        trackingPlanRepository.insertTrackingRelationToEvents(trackingPlan.getName(),eventList);

    }

    public List<TrackingPlan> getAllTrackingPlans() throws TrackingPlanNotFoundException {
        List<TrackingPlan> trackingPlans= trackingPlanRepository.getAllTrackingPlans();
        for(TrackingPlan trackingPlan: trackingPlans){
            List<String> eventsForPlan = trackingPlanRepository.getAllEventsForTrackingId(trackingPlan.getName().toLowerCase(Locale.ROOT));
            List<Event> events= new ArrayList<>();
            for(String event:eventsForPlan){
                events.add(eventService.getEvent(event));
            }
            trackingPlan.setEvents(events);
        }
        return trackingPlans;
    }

}
