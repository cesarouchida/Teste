package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User,String> {
    public List<User> findByLogin(@Param("login") String login);
}
