package Repository;

import Exceptions.TrackingPlanAlreadyExistsException;
import Exceptions.TrackingPlanNotFoundException;
import lombok.NonNull;
import model.Event;
import model.TrackingPlan;

import java.util.List;

public interface ITrackingPlanRepository {

    void addTrackingPlan(@NonNull final TrackingPlan trackingPlan) throws TrackingPlanAlreadyExistsException;

    void insertTrackingRelationToEvents(@NonNull final String trackingPlanId,@NonNull final List<String> events);

    List<TrackingPlan> getAllTrackingPlans() throws TrackingPlanNotFoundException;

    TrackingPlan getTrackingPlan(@NonNull final String trackingId) throws TrackingPlanNotFoundException;

    List<String> getAllEventsForTrackingId(@NonNull final String trackingId);
}
