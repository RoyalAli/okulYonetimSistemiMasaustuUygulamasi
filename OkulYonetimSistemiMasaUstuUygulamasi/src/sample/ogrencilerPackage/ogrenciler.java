package sample.ogrencilerPackage;

public class ogrenciler {
    private String ad;
    private String soyad;
    private String tcKimlikNumarasi;
    private String sinif;
    private int ogrenciNumarasi;

    private void setAd(String ad) {
        this.ad = ad;
    }

    private void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    private void setTcKimlikNumarasi(String tcKimlikNumarasi) { this.tcKimlikNumarasi = tcKimlikNumarasi; }

    private void setSinif(String sinif) {
        this.sinif = sinif;
    }

    private void setOgrenciNumarasi(int ogrenciNumarasi) {
        this.ogrenciNumarasi = ogrenciNumarasi;
    }

    public ogrenciler(String ad, String soyad, String tcKimlikNumarasi, String sinif, int ogrenciNumarasi) {
        setAd(ad);
        setSoyad(soyad);
        setTcKimlikNumarasi(tcKimlikNumarasi);
        setSinif(sinif);
        setOgrenciNumarasi(ogrenciNumarasi);
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

    public String getSinif() {
        return sinif;
    }

    public int getOgrenciNumarasi() {
        return ogrenciNumarasi;
    }
}