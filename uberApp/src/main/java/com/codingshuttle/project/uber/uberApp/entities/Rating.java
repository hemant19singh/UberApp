package com.codingshuttle.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        indexes = {
                @Index(name = "idx_rating_rider", columnList = "rider_id"),
                @Index(name = "idx_rating_driver", columnList = "driver_id")
        }
)
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ride ride;

    @ManyToOne
    private Rider rider;

    @ManyToOne
    private Driver driver;

    private Double riderRating;
    private Double driverRating;
}
