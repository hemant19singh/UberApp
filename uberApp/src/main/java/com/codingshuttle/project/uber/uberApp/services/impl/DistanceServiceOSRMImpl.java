package com.codingshuttle.project.uber.uberApp.services.impl;

import com.codingshuttle.project.uber.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private final static String OSRM_API="http://router.project-osrm.org/route/v1/driving/";


    @Override
    public double calculateDistance(Point src, Point dest) {

        try {
            String coordinates = src.getX()+","+src.getY()+";"+dest.getX()+","+dest.getY();
            OSRMResponseDto responseDto = RestClient.builder()
                    .baseUrl(OSRM_API)
                    .build()
                    .get()
                    .uri(coordinates)
                    .retrieve()
                    .body(OSRMResponseDto.class);

            return responseDto.getRoutes().get(0).getDistance() / 1000.0;
        } catch (Exception e) {
            throw new RuntimeException("Error getting data from OSRM: "+e.getMessage());
        }
    }
}


@Data
class OSRMResponseDto {
    private List<OSRMRoute> routes;
}

@Data
class OSRMRoute{
    private Double distance;
}
