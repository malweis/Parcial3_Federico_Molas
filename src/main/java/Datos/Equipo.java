package Datos;

public class Equipo  {
    private int codigoE;
    private int añotT;
    private int partidosG;
    private int partidosP;
    private int partidosE;
    private int posicionN;
    private int mayorGD;
    private int mayorGR;


    private String nombreE;
    private String nombreEn;
    private String codigoTemp;
    private String ciudadE;
    private char estadoE;

    public  Equipo (){
        codigoE = 0;
        añotT = 0;
        partidosG = 0;
        partidosP = 0;
        partidosE = 0;
        posicionN = 0;
        mayorGD = 0;
        mayorGR = 0;
        nombreE = " ";
        nombreEn = " ";
        codigoTemp = " ";
        ciudadE = " ";
        estadoE = ' ';
    }
    public Equipo(int codigoE, int añotT, int partidosG, int partidosP, int partidosE, int posicionN, int mayorGD, int mayorGR, String nombreE, String nombreEn, String codigoTemp, String ciudadE, char estadoE) {
        this.codigoE = codigoE;
        this.añotT = añotT;
        this.partidosG = partidosG;
        this.partidosP = partidosP;
        this.partidosE = partidosE;
        this.posicionN = posicionN;
        this.mayorGD = mayorGD;
        this.mayorGR = mayorGR;
        this.nombreE = nombreE;
        this.nombreEn = nombreEn;
        this.codigoTemp = codigoTemp;
        this.ciudadE = ciudadE;
        this.estadoE = estadoE;
    }

    public int getCodigoE() {
        return codigoE;
    }

    public void setCodigoE(int codigoE) {
        this.codigoE = codigoE;
    }

    public int getAñotT() {
        return añotT;
    }

    public void setAñotT(int añotT) {
        this.añotT = añotT;
    }

    public int getPartidosG() {
        return partidosG;
    }

    public void setPartidosG(int partidosG) {
        this.partidosG = partidosG;
    }

    public int getPartidosP() {
        return partidosP;
    }

    public void setPartidosP(int partidosP) {
        this.partidosP = partidosP;
    }

    public int getPartidosE() {
        return partidosE;
    }

    public void setPartidosE(int partidosE) {
        this.partidosE = partidosE;
    }

    public int getPosicionN() {
        return posicionN;
    }

    public void setPosicionN(int posicionN) {
        this.posicionN = posicionN;
    }

    public int getMayorGD() {
        return mayorGD;
    }

    public void setMayorGD(int mayorGD) {
        this.mayorGD = mayorGD;
    }

    public int getMayorGR() {
        return mayorGR;
    }

    public void setMayorGR(int mayorGR) {
        this.mayorGR = mayorGR;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombreEn() {
        return nombreEn;
    }

    public void setNombreEn(String nombreEn) {
        this.nombreEn = nombreEn;
    }

    public String getCodigoTemp() {
        return codigoTemp;
    }

    public void setCodigoTemp(String codigoTemp) {
        this.codigoTemp = codigoTemp;
    }

    public String getCiudadE() {
        return ciudadE;
    }

    public void setCiudadE(String ciudadE) {
        this.ciudadE = ciudadE;
    }

    public char getEstadoE() {
        return estadoE;
    }

    public void setEstadoE(char estadoE) {
        this.estadoE = estadoE;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "codigoE=" + codigoE +
                ", añotT=" + añotT +
                ", partidosG=" + partidosG +
                ", partidosP=" + partidosP +
                ", partidosE=" + partidosE +
                ", posicionN=" + posicionN +
                ", mayorGD=" + mayorGD +
                ", mayorGR=" + mayorGR +
                ", nombreE='" + nombreE + '\'' +
                ", nombreEn='" + nombreEn + '\'' +
                ", codigoTemp='" + codigoTemp + '\'' +
                ", ciudadE='" + ciudadE + '\'' +
                ", estadoE=" + estadoE +
                '}';
    }


}
