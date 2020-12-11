package com.example.panovnicicech;

public class Kralove {
    private String jmeno,poradi, zil, vladnul, poznamka;

    public Kralove( String poradi, String jmeno, String zil, String vladnul, String poznamka) {
        this.poradi = poradi;
        this.jmeno = jmeno;
        this.zil = zil;
        this.vladnul = vladnul;
        this.poznamka = poznamka;
    }

    public Kralove() {
        this.jmeno = "";
        this.poradi = "";
        this.zil = "";
        this.vladnul = "";
        this.poznamka = "";
    }

    @Override
    public String toString()
    {
        return poradi + "\n"+ zil + "\n" + vladnul + "\n" + poznamka;
    }

    public String getPoradi() {
        return poradi;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getZil() {
        return zil;
    }

    public String getVladnul() {
        return vladnul;
    }

    public String getPoznamka() {
        return poznamka;
    }


    public void setPoradi(String poradi) {
        this.poradi = poradi;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setZil(String zil) {
        this.zil = zil;
    }

    public void setVladnul(String vladnul) {
        this.vladnul = vladnul;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }
}

