package com.kyedev.springJDBCDemo.repo;


import com.kyedev.springJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlienRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AlienRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Alien alien) {
        String sql = "insert into alien (id, name, tech) values (?,?,?)";
        int rows =  jdbcTemplate.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println(rows +" row/s affected");
    }


    public List<Alien> findAll() {
        String sql = "select * from alien";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Alien a = new Alien();
            a.setId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setTech(rs.getString("tech"));

            return a;
        });
    }
}
