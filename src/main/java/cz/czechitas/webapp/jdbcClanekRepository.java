package cz.czechitas.webapp;

import java.sql.*;
import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;

public class jdbcClanekRepository {

    private MariaDbDataSource konfiguraceDb;
    JdbcTemplate dotazovac;
    RowMapper<Clanek> mapovacClanku;

    public jdbcClanekRepository() {
        try {
            konfiguraceDb = new MariaDbDataSource();
            konfiguraceDb.setUserName("student");
            konfiguraceDb.setPassword("password");
            konfiguraceDb.setUrl("jdbc:mysql://localhost:3306/DailyPlanet_athena");

            dotazovac = new JdbcTemplate(konfiguraceDb);

            mapovacClanku = BeanPropertyRowMapper.newInstance(Clanek.class);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Clanek> findAll() {
        return dotazovac.query(
                "select * from clanky order by ID", mapovacClanku);

    }

    public Clanek findOne(Long id) {

        return dotazovac.queryForObject(
                "select * from clanky where id = ?", mapovacClanku, id);

    }

    public Clanek save(Clanek zaznamKUlozeni) {
        return null;

    }

    public void delete(Long id) {

        
    }

}
