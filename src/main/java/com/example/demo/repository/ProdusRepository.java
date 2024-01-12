package com.example.demo.repository;

import com.example.demo.entity.Cumparatori;
import com.example.demo.entity.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdusRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Produs> findAll() {
        return jdbcTemplate.query("SELECT * FROM produs", (resultSet, rowNum) -> {
            Produs produs = new Produs();
            produs.setCodProdus(resultSet.getInt("codProdus"));
            produs.setDenumire(resultSet.getString("denumire"));
            produs.setPret(resultSet.getDouble("pret"));
            produs.setStoc(resultSet.getInt("stoc"));
            return produs;
        });
    }

    public List<Produs> findByCodProdus(int codProdus) {
        String query = "SELECT * FROM produs WHERE codProdus = ?";

        return jdbcTemplate.query(query, new Object[]{codProdus}, (resultSet, rowNum) -> {
            Produs produs = new Produs();
            produs.setCodProdus(resultSet.getInt("codProdus"));
            produs.setDenumire(resultSet.getString("denumire"));
            produs.setPret(resultSet.getDouble("pret"));
            produs.setStoc(resultSet.getInt("stoc"));
            return produs;
        });
    }

    public void createProdus(Produs produs) {
        String sql = "insert into produs(codProdus, denumire, pret, stoc) values (?, ?, ?, ?)";

        jdbcTemplate.update(sql, produs.getCodProdus(), produs.getDenumire(), produs.getPret(), produs.getStoc());
    }

    public boolean existBycodProdus(Integer codProdus) {
        String sql = "SELECT count(*) FROM produs where codProdus = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, codProdus);

        return count > 0;
    }

    public void updateProdus(int codProdus, Produs produs) {
        String sql = "update produs set denumire = ?, pret = ?, stoc = ? where codProdus = ?";

        jdbcTemplate.update(sql, produs.getDenumire(), produs.getPret(), produs.getStoc(), codProdus);
    }

    public void deleteProdus(Integer codProdus) {
        String sql = "DELETE FROM produs where codProdus = ?";

        jdbcTemplate.update(sql, codProdus);
    }
}
