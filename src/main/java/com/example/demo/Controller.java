package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class Controller {

    List<BillettInfo> liste = new ArrayList<>();

    @Autowired
    BillettInfoRepository rep;

    //Legger inn verdier til database (tilkaller)
    @PostMapping("/leggInn")
    public void leggInn(BillettInfo billettInfo){
        rep.lagreBillettInfo(billettInfo);

    }

    //Henter all data og sorterer ved hjelp av comparator (tilkaller)
    @GetMapping("/vis")
    public List<BillettInfo> hentInfo(){
        liste= rep.hentAllBillettInfo();
        Collections.sort(liste,new ComparatorForEtternavn());
        return liste;
    }

    //Sletter all informasjon fra database(tilkaller)
    @PostMapping("/slett")
    public void slettListe(){

        rep.slettAllBillettInfo();
    }

}