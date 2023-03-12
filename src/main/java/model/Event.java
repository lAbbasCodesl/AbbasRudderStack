package model;

import com.networknt.schema.JsonSchema;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.json.JSONObject;

@AllArgsConstructor
@Getter
public class Event {
    String name;
    String description;
    JsonSchema rules;
}
