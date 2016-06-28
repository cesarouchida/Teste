package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDAOImpl implements UserDetailsService{

    @Autowired
    private UserDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = dao.findByLogin(username);

        if (users.isEmpty()){
            throw new UsernameNotFoundException("O usuario " + username + " não existe");
        }

        return users.get(0);
    }
}
