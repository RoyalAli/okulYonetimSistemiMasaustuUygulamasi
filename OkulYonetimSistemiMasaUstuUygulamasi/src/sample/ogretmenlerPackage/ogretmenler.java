package sample.ogretmenlerPackage;

public class ogretmenler {
    private String ad;
    private String soyad;
    private String tcKimlikNumarasi;
    private String brans;
    private int ogretmenNumarasi;

    private void setAd(String ad) {
        this.ad = ad;
    }

    private void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    private void setTcKimlikNumarasi(String tcKimlikNumarasi) { this.tcKimlikNumarasi = tcKimlikNumarasi; }

    private void setBrans(String brans) {
        this.brans = brans;
    }

    private void setOgretmenNumarasi(int ogretmenNumarasi) {
        this.ogretmenNumarasi = ogretmenNumarasi;
    }

    public ogretmenler(String ad, String soyad, String tcKimlikNumarasi, String brans, int ogretmenNumarasi) {
        setAd(ad);
        setSoyad(soyad);
        setTcKimlikNumarasi(tcKimlikNumarasi);
        setBrans(brans);
        setOgretmenNumarasi(ogretmenNumarasi);
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

    public String getBrans() {
        return brans;
    }

    public int getOgretmenNumarasi() {
        return ogretmenNumarasi;
    }
}