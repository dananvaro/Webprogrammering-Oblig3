package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillettInfoRepository {

    //Koplingen opp mot database
    @Autowired
    private JdbcTemplate db;

    //Legger til nye verdier i databasen
    public void lagreBillettInfo(BillettInfo billett){
        String sql = "INSERT INTO BillettInfo (antall,fornavn,etternavn,telefonnr,epost,film) VALUES(?,?,?,?,?,?)";

        db.update(sql, billett.getAntall(), billett.getFornavn(),billett.getEtternavn(),billett.getTelefonnr(),
                billett.getEpost(),billett.getFilm());
    }

    //Henter all info billetter
    public List<BillettInfo>hentAllBillettInfo(){
        String sql = "SELECT * FROM BillettInfo";

        List<BillettInfo> allBilettInfo = db .query(sql, new BeanPropertyRowMapper(BillettInfo.class));

        return allBilettInfo;
    }

    //Sletter alle verdier fra databasen.
    public void slettAllBillettInfo(){
        String sql = "DELETE FROM BillettInfo";
        db.update(sql);
    }
}
