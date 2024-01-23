package com.example.spring_hm_3.repositories;

import com.example.spring_hm_3.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {
  private final JdbcTemplate jdbc;

  @Autowired
  public UsersRepository(JdbcTemplate jdbcTemplate) {
    this.jdbc = jdbcTemplate;
  }

  /**
   * Возвращает список пользователей
   * @return
   */
  public List<User> selectAllFromDB(){
    String sql = "SELECT * FROM userTable";

    RowMapper<User> userRowMapper = (r, i) -> {
      User rowObject = new User();
      rowObject.setId(r.getInt("id"));
      rowObject.setName(r.getString("name"));
      rowObject.setAge(r.getInt("age"));
      rowObject.setEmail(r.getString("email"));
      return rowObject;
    };
    return jdbc.query(sql, userRowMapper);
  }

  /**
   *  Добавляет пользователя в БД, если пользователя с такой почтой нету в БД
   */
  public void add(User user) {
    String sql = "INSERT INTO userTable (name, age, email) VALUES (?, ?, ?)";
    jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
  }

}