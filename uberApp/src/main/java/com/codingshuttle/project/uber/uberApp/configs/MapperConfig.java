package com.codingshuttle.project.uber.uberApp.configs;

import com.codingshuttle.project.uber.uberApp.dto.PointDto;
import com.codingshuttle.project.uber.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper mapper = new ModelMapper();

        mapper.typeMap(PointDto.class, Point.class).setConverter(converter -> {
            PointDto pointDto = converter.getSource();
            return GeometryUtil.createPoint(pointDto);

        });

        mapper.typeMap(Point.class, PointDto.class).setConverter(converter -> {
            Point point = converter.getSource();
            double[] coordinates = {
                    point.getX(), point.getY()
            };
            return new PointDto(coordinates);
        });

        return mapper;
    }
}
