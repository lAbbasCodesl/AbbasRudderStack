package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class TrackingPlan {
    String name;

    @Setter
    List<Event> events;


    public TrackingPlan(String name){
        this.name=name;
    }
}
