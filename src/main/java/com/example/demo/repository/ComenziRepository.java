package com.example.demo.repository;

import com.example.demo.entity.Comenzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComenziRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Comenzi> findAll() {
        return jdbcTemplate.query("SELECT * FROM comenzi", (resultSet, rowNum) -> {
            Comenzi comenzi = new Comenzi();
            comenzi.setComandaID(resultSet.getInt("comandaID"));
            comenzi.setProdus(resultSet.getString("produs"));
            comenzi.setCantitate(resultSet.getInt("cantitate"));
            comenzi.setTotalComanda(resultSet.getDouble("totalcomanda"));
            comenzi.setDataComenzii(resultSet.getString("datacomenzii"));
            comenzi.setCumparatorID(resultSet.getInt("cumparatorID"));
            return comenzi;
        });
    }

    public List<Comenzi> findByCumparatorID(int cumparatorID) {
        String query = "SELECT * FROM comenzi WHERE cumparatorID = ?";

        return jdbcTemplate.query(query, new Object[]{cumparatorID}, (resultSet, rowNum) -> {
            Comenzi comenzi = new Comenzi();
            comenzi.setCumparatorID(resultSet.getInt("cumparatorID"));
            comenzi.setComandaID(resultSet.getInt("comandaID"));
            comenzi.setProdus(resultSet.getString("produs"));
            comenzi.setCantitate(resultSet.getInt("cantitate"));
            comenzi.setTotalComanda(resultSet.getDouble("totalcomanda"));
            comenzi.setDataComenzii(resultSet.getString("datacomenzii"));
            return comenzi;
        });
    }

    public List<Comenzi> findByComandaID(int comandaID) {
        String query = "SELECT * FROM comenzi WHERE comandaID = ?";

        return jdbcTemplate.query(query, new Object[]{comandaID}, (resultSet, rowNum) -> {
            Comenzi comenzi = new Comenzi();
            comenzi.setComandaID(resultSet.getInt("comandaID"));
            comenzi.setProdus(resultSet.getString("produs"));
            comenzi.setCantitate(resultSet.getInt("cantitate"));
            comenzi.setTotalComanda(resultSet.getDouble("totalcomanda"));
            comenzi.setDataComenzii(resultSet.getString("datacomenzii"));
            comenzi.setCumparatorID(resultSet.getInt("cumparatorID"));
            return comenzi;
        });
    }

    public void createComanda(Comenzi comenzi) {
        String sql = "insert into comenzi(comandaID, produs, cantitate, totalcomanda, datacomenzii, cumparatorID) values (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, comenzi.getComandaID(), comenzi.getProdus(), comenzi.getCantitate(), comenzi.getTotalComanda(), comenzi.getDataComenzii(), comenzi.getCumparatorID());
    }

    public boolean existById(Integer comandaID) {
        String sql = "SELECT count(*) FROM comenzi where comandaID = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, comandaID);

        return count > 0;
    }

    public boolean existByIdCumparator(Integer cumparatorID) {
        String sql = "SELECT count(*) FROM comenzi where cumparatorID = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, cumparatorID);

        return count > 0;
    }

    public void updateComanda(Integer comandaID, Comenzi comenzi) {
        String sql = "update comenzi set produs = ?, cantitate = ?, totalcomanda = ?, datacomenzii = ?, cumparatorID = ?  where comandaID = ?";

        jdbcTemplate.update(sql, comenzi.getProdus(), comenzi.getCantitate(), comenzi.getTotalComanda(), comenzi.getDataComenzii(), comenzi.getCumparatorID(), comandaID);
    }

    public void deleteComanda(Integer comandaID) {
        String sql = "DELETE FROM comenzi where comandaID = ?";

        jdbcTemplate.update(sql, comandaID);
    }

}

