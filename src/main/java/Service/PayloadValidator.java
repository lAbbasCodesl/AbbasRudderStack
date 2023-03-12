package Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import lombok.NonNull;
import org.json.JSONObject;

import java.util.Set;

public class PayloadValidator {

    public boolean isValidPayload(@NonNull final JSONObject payLoad,@NonNull final JsonSchema jsonSchema) throws JsonProcessingException {
        boolean isValid=true;
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node=objectMapper.readTree(payLoad.toString());
        Set<ValidationMessage> errors = jsonSchema.validate(node);
        if(errors.size()>0){
            isValid=false;
        }
        return isValid;
    }
}
