package com.murtekbey.springbootpetclinicdemo.dao.jdbc;

import com.murtekbey.springbootpetclinicdemo.dao.OwnerRepository;
import com.murtekbey.springbootpetclinicdemo.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepositoryJdbcImpl implements OwnerRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Owner> rowMapper = (rs, rowNum) -> {
        Owner owner = new Owner();
        owner.setId(rs.getLong("id"));
        owner.setFirstName(rs.getString("first_name"));
        owner.setLastName(rs.getString("last_name"));
        return owner;
    };

    @Autowired
    public OwnerRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Owner> findAll() {
        String sql = "select id, first_name, last_name from t_owner";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Owner findById(Long id) {
        String sql = "select id, first_name, last_name from t_owner where id = ?";
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, id));
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        String sql = "select id, first_name, last_name from t_owner where last_name like ?";
        return jdbcTemplate.query(sql, rowMapper, "%" + lastName + "%" );
    }

    @Override
    public void create(Owner owner) {

    }

    @Override
    public Owner update(Owner owner) {
        return null;
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from t_owner where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
