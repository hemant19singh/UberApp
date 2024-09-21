# UberApp
Basic UberApp backend using SpringBoot and PostGIS for using map in Postgres database.

## Features
- Signing up a user a rider by default.
- Admins can make a user as a driver, so a user can be both a rider & a driver.
- Rider can book a ride & driver can accept/cancel a ride.
- Once driver accepted a ride, his availability is marked as 'false'.
- Driver/Rider can not cancel a rider once it is started.
- Once a ride is started, email is sent to rider and driver about the same.
- RideRequest object will be created once a ride is requested.
- Ride object will be created from existing RideRequest object once the requested ride is accepted.
- There are 2 strategies to match drivers (based on rating & based on distance)
- There are 2 strategies to calculate the fare (based on distance & based on surge timings)
- Payment options are in-app wallet or cash.
- Rider can rate a driver & driver can rate a rider.
- Other basic functions include like: getMyProfile, getMyRides, getMyWallet etc.
