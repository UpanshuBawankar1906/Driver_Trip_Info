package org.bootcoding.repo;

import org.bootcoding.model.Drivers;
import org.bootcoding.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TripRepoImpl implements TripRepo{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Trip insert(Trip trip) {
        jdbcTemplate.update("INSERT into trip(id,driverid, drivername,start_location, end_location, " +
                        "distance, fare) " + "values(?,?,?,?,?,?,?)",
                trip.getId(), trip.getDriverid(), trip.getDrivername(), trip.getStart_location(),
                trip.getEnd_location(), trip.getDistance(), trip.getFare());
        return trip;
    }

    @Override
    public List<Trip> getAll() {
        return jdbcTemplate.query("select * from trip",(rs,rowNum) ->{
            return new Trip(rs.getInt(1),rs.getInt(2),rs.getString(3)
            ,rs.getString(4),rs.getString(5),rs.getInt(6),
                    rs.getDouble(7));
        });
    }

    @Override
    public Trip update(Trip trip){

        System.out.println(trip.getDistance());

        jdbcTemplate.update("update trip set driverid=? , drivername=? , start_location=? , end_location=? , " +
                        "distance=? , fare=?  where id=?",  trip.getDriverid(),
                trip.getDrivername(), trip.getStart_location(), trip.getEnd_location(), trip.getDistance(),
                trip.getFare(), trip.getId());
        return trip;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from trip where id=?", id);

    }

    @Override
    public Trip getById(int id) {
        return jdbcTemplate.queryForObject("select * from trip where id=?", (rs, rowNum) -> {
            return new Trip(rs.getInt(1), rs.getInt(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),rs.getInt(6),
                    rs.getDouble(7));}, id);
    }
}
