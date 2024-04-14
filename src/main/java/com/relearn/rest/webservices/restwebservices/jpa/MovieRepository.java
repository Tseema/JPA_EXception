package com.relearn.rest.webservices.restwebservices.jpa;
import com.relearn.rest.webservices.restwebservices.user.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class MovieRepository {
    @Autowired
    private JdbcTemplate template;

    //@PostConstruct
    public void createTable() {
        template.execute("CREATE TABLE movies (id bigint auto_increment primary key, name VARCHAR(50), year int, rating int)");
    }

    public void createMovie(String name, int year, int rating) {
        template.update("INSERT INTO movies (id, name, year, rating) VALUES (?,?,?,?)",
                null, name, year, rating);
    }

    public List<Movie> findMoviesByName(String nameStartsWith) {
        // Write your code here
        //List<Movie> result = new ArrayList<>();
        //List<Movie> finalMovie = new ArrayList<>();
        //template.execute("select * from Movies");
        //result = template.queryForList("select * from Movies",Movie.class);
        return template.query(" select * from movies where name LIKE '" + nameStartsWith + "%' ",
                (rs, rowNum) -> {
                    return new Movie(rs.getString("name"),
                            rs.getInt("year"), rs.getInt("rating"));
                });

               /* template.query("SELECT * FROM movies WHERE name LIKE '" + nameStartsWith + "%'",
                (rs, rowNum) -> new Movie(rs.getString("name"),
                        rs.getInt("year"), rs.getInt("rating")));*/


         //template.queryForObject("select * from Movies", List<>);
        /*result.forEach(movie -> {if(movie.name.startsWith(nameStartsWith))
            finalMovie.add(movie);});*/
        //return finalMovie;
    }
}
