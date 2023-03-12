package Repository;


import Exceptions.TrackingPlanAlreadyExistsException;
import Exceptions.TrackingPlanNotFoundException;
import lombok.NonNull;
import model.Event;
import model.TrackingPlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TrackingPlanRepositoryInMemory implements ITrackingPlanRepository {

    private Map<String, TrackingPlan> trackingPlanMap;
    private Map<String, List<String>> planToEventMap;


    @Override
    public void addTrackingPlan(@NonNull final TrackingPlan trackingPlan) throws TrackingPlanAlreadyExistsException{
        if(trackingPlanMap.get(trackingPlan.getName().toLowerCase(Locale.ROOT))!=null){
            throw new TrackingPlanAlreadyExistsException("Tracking plan already created with same name");
        }
        trackingPlanMap.put(trackingPlan.getName(),trackingPlan);
    }

    @Override
    public void insertTrackingRelationToEvents(@NonNull final String trackingPlanId,@NonNull final  List<String> events) {
        planToEventMap.put(trackingPlanId,events);
    }

    @Override
    public List<TrackingPlan> getAllTrackingPlans() throws TrackingPlanNotFoundException{
        if(trackingPlanMap.size()==0){
            throw new TrackingPlanNotFoundException("No tracking plans exist");
        }
        return new ArrayList<>(trackingPlanMap.values());
    }

    @Override
    public TrackingPlan getTrackingPlan(@NonNull final String trackingId) throws TrackingPlanNotFoundException {
        if(trackingPlanMap.get(trackingId)==null){
            throw new TrackingPlanNotFoundException("Tracking plan does not exist");
        }
        return trackingPlanMap.get(trackingId);
    }

    @Override
    public List<String> getAllEventsForTrackingId(@NonNull final String trackingId) {
        return new ArrayList<>(planToEventMap.get(trackingId));
    }


}
