package com.example.demo;

import java.util.Comparator;

public class ComparatorForEtternavn implements Comparator<BillettInfo> {

    //Sammenligner etternavn
    @Override
    public int compare(BillettInfo o1, BillettInfo o2) {

        return o1.getEtternavn().compareToIgnoreCase(o2.getEtternavn());
    }
}
