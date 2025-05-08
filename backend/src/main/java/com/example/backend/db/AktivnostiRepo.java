package com.example.backend.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.backend.models.Aktivnost;

public class AktivnostiRepo implements AktivnostiRepoInterface{
     @Override
    public List<Aktivnost> dohvatiAktuelneAktivnosti() {

        List<Aktivnost> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from aktivnosti where status = 1")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aktivnost a = new Aktivnost(
                        rs.getInt("id"),
                        rs.getString("naziv"),
                        rs.getString("datum_vreme"),
                        rs.getString("napravio"),
                        rs.getInt("status"),
                        rs.getInt("sala1"),
                        rs.getInt("sala2"),
                        rs.getInt("sala3"));

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public List<Aktivnost> dohvatiMojeAktivnosti(String username) {

        List<Aktivnost> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "select * from aktivnosti where napravio = ?")) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aktivnost a = new Aktivnost(
                        rs.getInt("id"),
                        rs.getString("naziv"),
                        rs.getString("datum_vreme"),
                        rs.getString("napravio"),
                        rs.getInt("status"),
                        rs.getInt("sala1"),
                        rs.getInt("sala2"),
                        rs.getInt("sala3"));
                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public boolean promeniStatus(Aktivnost aktivnost) {
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtUpdate = conn
                        .prepareStatement("update aktivnosti set status = abs(status - 1) where id = ?")) {
            stmtUpdate.setInt(1, aktivnost.getId());

            return stmtUpdate.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
