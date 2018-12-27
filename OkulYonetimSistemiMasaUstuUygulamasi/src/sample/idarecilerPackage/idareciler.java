package sample.idarecilerPackage;

public class idareciler {
    private String ad;
    private String soyad;
    private String tcKimlikNumarasi;
    private String pozisyon;
    private int idareciNumarasi;

    private void setAd(String ad) {
        this.ad = ad;
    }

    private void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    private void setTcKimlikNumarasi(String tcKimlikNumarasi) { this.tcKimlikNumarasi = tcKimlikNumarasi; }

    private void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    private void setIdareciNumarasi(int idareciNumarasi) {
        this.idareciNumarasi = idareciNumarasi;
    }

    public idareciler(String ad, String soyad, String tcKimlikNumarasi, String pozisyon, int idareciNumarasi) {
        setAd(ad);
        setSoyad(soyad);
        setTcKimlikNumarasi(tcKimlikNumarasi);
        setPozisyon(pozisyon);
        setIdareciNumarasi(idareciNumarasi);
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getTcKimlikNumarasi() {
        return tcKimlikNumarasi;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public int getIdareciNumarasi() {
        return idareciNumarasi;
    }
}