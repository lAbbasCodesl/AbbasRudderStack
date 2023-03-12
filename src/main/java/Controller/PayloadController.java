package Controller;

import Service.EventService;
import Service.PayloadValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.deploy.net.HttpResponse;
import lombok.AllArgsConstructor;
import model.Event;
import org.json.JSONObject;

@AllArgsConstructor
public class PayloadController {
    private EventService eventService;

    public void processEvent(JSONObject payload){

        String name = payload.getString("name");
        Event event= eventService.getEvent(name);
        if(event==null){
            //respond with 404 invalid event

        }
        PayloadValidator payloadValidator= new PayloadValidator();
        try {
            boolean isValid= payloadValidator.isValidPayload(payload,event.getRules());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // Do further processing
    }
}
