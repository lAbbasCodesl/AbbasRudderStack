package Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TrackingPlanAlreadyExistsException extends Exception{
    String message;
}
