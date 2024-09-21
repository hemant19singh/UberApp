package com.codingshuttle.project.uber.uberApp.strategies;

import com.codingshuttle.project.uber.uberApp.strategies.impl.DriverMatchingHighestRatedStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@RequiredArgsConstructor
@Component
public class RideStrategyManager {

    private final DriverMatchingHighestRatedStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;

    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RideFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if(riderRating >= 4.8){
            return highestRatedDriverStrategy;
        }
        return nearestDriverStrategy;
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){

        //Surge time: 6pm to 9pm
        LocalTime surgeStartTime = LocalTime.of(16,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime) return surgePricingFareCalculationStrategy;
        return defaultFareCalculationStrategy;
    }

}
