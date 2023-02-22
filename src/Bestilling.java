import java.util.Date;

public class Bestilling {
/* vi skal bruge:
* dato for behandling
* klokkeslæt
* hvornår aftalen er lavet
* hvilken behandling
* tid behandling tager
* pris
* status(f.eks. aflyst, afsluttet, bestilt etc.) v
* */
    private Date dato;
    private String klokkeslæt;
    private String behandlingsType;
    private double behandlingsTid;
    private double pris;
    private String status;
    private int bestillingID;
    private int kunde;
    private int medarbejder;

    public Bestilling(int bestillingID, Date dato, String klokkeslæt, String behandlingsType, double behandlingsTid, double pris, int kunde, int medarbejder ,String status) {
        this.bestillingID = bestillingID;
        this.dato = dato;
        this.klokkeslæt = klokkeslæt;
        this.behandlingsType = behandlingsType;
        this.behandlingsTid = behandlingsTid;
        this.pris = pris;
        this.kunde = kunde;
        this.medarbejder = medarbejder;
        this.status = status;

    }

    public Date getDato() {
        return dato;
    }
    public void setDato(Date dato) {
        this.dato = dato;
    }

    public String getKlokkeslæt() {
        return klokkeslæt;
    }
    public void setKlokkeslæt(String klokkeslæt) {
        this.klokkeslæt = klokkeslæt;
    }

    public String getBehandlingsType() {
        return behandlingsType;
    }
    public void setBehandlingsType(String behandlingsType) {
        this.behandlingsType = behandlingsType;
    }

    public double getBehandlingsTid() {
        return behandlingsTid;
    }
    public void setBehandlingsTid(double behandlingsTid) {
        this.behandlingsTid = behandlingsTid;
    }

    public double getPris() {
        return pris;
    }
    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getBestillingID() {
        return bestillingID;
    }
    public void setBestillingID(int bestillingID) {
        bestillingID = bestillingID;
    }

    public int getKunde() {
        return kunde;
    }
    public void setKunde(int kunde) {
        this.kunde = kunde;
    }

    public int getMedarbejder() {
        return medarbejder;
    }
    public void setMedarbejder(int medarbejder) {
        this.medarbejder = medarbejder;
    }
}
