package com.example.md;

public class kralove {
    private String jmeno,poradi, zil, vladnul, poznamka;

    public kralove(String jmeno, String poradi, String zil, String vladnul, String poznamka) {
        this.jmeno = jmeno;
        this.poradi = poradi;
        this.zil = zil;
        this.vladnul = vladnul;
        this.poznamka = poznamka;
    }

    public kralove() {
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

    //Setry
    public void setJmeno(String jmeno) { this.jmeno = jmeno; }
    public void setPoradi(String poradi) { this.poradi = poradi; }
    public void setZil(String zil) { this.zil = zil; }
    public void setVladnul(String vladnul) { this.vladnul = vladnul; }
    public void setPoznamka(String poznamka) { this.poznamka = poznamka; }

    //Getry
    public String getJmeno() { return jmeno; }
    public String getPoradi() { return poradi; }
    public String getZil() { return zil; }
    public String getVladnul() { return vladnul; }
    public String getPoznamka() { return poznamka; }
}
