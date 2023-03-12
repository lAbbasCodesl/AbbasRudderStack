package Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TrackingPlanNotFoundException extends Exception{
    String message;
}
