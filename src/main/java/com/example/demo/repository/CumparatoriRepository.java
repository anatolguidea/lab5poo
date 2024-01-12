package com.example.demo.repository;

import com.example.demo.entity.Comenzi;
import com.example.demo.entity.Cumparatori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CumparatoriRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cumparatori> findAll() {
        return jdbcTemplate.query("SELECT * FROM cumparatori", (resultSet, rowNum) -> {
            Cumparatori cumparatori = new Cumparatori();
            cumparatori.setCumparatorID(resultSet.getInt("cumparatorID"));
            cumparatori.setNume(resultSet.getString("nume"));
            cumparatori.setPrenume(resultSet.getString("prenume"));
            cumparatori.setEmail(resultSet.getString("email"));
            cumparatori.setTelefon(resultSet.getString("telefon"));
            cumparatori.setAdresa(resultSet.getString("adresa"));
            return cumparatori;
        });
    }

    public List<Cumparatori> findByCumparatorID(int cumparatorID) {
        String query = "SELECT * FROM cumparatori WHERE cumparatorID = ?";

        return jdbcTemplate.query(query, new Object[]{cumparatorID}, (resultSet, rowNum) -> {
            Cumparatori cumparatori = new Cumparatori();
            cumparatori.setCumparatorID(resultSet.getInt("cumparatorID"));
            cumparatori.setNume(resultSet.getString("nume"));
            cumparatori.setPrenume(resultSet.getString("prenume"));
            cumparatori.setEmail(resultSet.getString("email"));
            cumparatori.setTelefon(resultSet.getString("telefon"));
            cumparatori.setAdresa(resultSet.getString("adresa"));
            return cumparatori;
        });
    }

    public void createCumparator(Cumparatori cumparatori) {
        String sql = "insert into cumparatori(cumparatorID, nume, prenume, email, telefon, adresa) values (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, cumparatori.getCumparatorID(), cumparatori.getNume(), cumparatori.getPrenume(), cumparatori.getEmail(), cumparatori.getTelefon(), cumparatori.getAdresa());
    }

    public boolean existById(Integer cumparatorID) {
        String sql = "SELECT count(*) FROM cumparatori where cumparatorID = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, cumparatorID);

        return count > 0;
    }

    public void updateCumparator(Integer cumparatorID, Cumparatori cumparatori) {
        String sql = "update cumparatori set nume = ?, prenume = ?, email = ?, telefon = ?, adresa = ?  where cumparatorID = ?";

        jdbcTemplate.update(sql, cumparatori.getNume(), cumparatori.getPrenume(), cumparatori.getEmail(), cumparatori.getTelefon(), cumparatori.getAdresa(), cumparatorID);
    }

    public void deleteCumparator(Integer cumparatorID) {
        String sql = "DELETE FROM cumparatori where cumparatorID = ?";

        jdbcTemplate.update(sql, cumparatorID);
    }
}
