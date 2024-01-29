package org.bootcoding.repo;

import org.bootcoding.model.Drivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DriverRepoImpl implements DriverRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Drivers insert(Drivers drivers) {
        jdbcTemplate.update("INSERT into drivers(id,name,phoneno,licenseno,address,age,gender,exp) " +
                        "values(?,?,?,?,?,?,?,?)",
                drivers.getId(),drivers.getName(),drivers.getPhone_no(),drivers.getLicense_no()
                ,drivers.getAddress(),drivers.getAge(),drivers.getGender(),drivers.getExp());
        return drivers;
    }

    @Override
    public List<Drivers> getAll() {
        return jdbcTemplate.query("select * from drivers",(rs,rowNum) ->{
            return new Drivers(rs.getInt(1),rs.getString(2),rs.getString(3)
            ,rs.getString(4),rs.getString(5),rs.getInt(6),
                    rs.getString(7), rs.getInt(8));
        });
    }

    @Override
    public Drivers update(Drivers drivers){

        jdbcTemplate.update("update drivers set name=? , phoneno=? , licenseno=? , address=? , " +
                "age=? , gender=? , exp=? where id=?", drivers.getName(), drivers.getPhone_no(),
                drivers.getLicense_no(), drivers.getAddress(), drivers.getAge(),drivers.getGender(),
                drivers.getExp(),drivers.getId());
        return drivers;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from drivers where id=?", id);

    }

    @Override
    public Drivers getById(int id) {
        return jdbcTemplate.queryForObject("select * from drivers where id=?", (rs, rowNum) -> {
            return new Drivers(rs.getInt("id"),rs.getString("name"),
                    rs.getString("phoneno"),rs.getString("licenseno"),
                    rs.getString("address"),rs.getInt("age"),rs.getString("gender"),
            rs.getInt("exp"));
        }, id);
    }
}
