/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Pra non sobrecargar a clase comuneiro, meto aqui os datos da direccion
 * @author Jose PS
 */
public class Direccion {
    private String rua;
    private String provincia;
    private String localidade;
    private String Aldea;
    private String numero;
    private String cp;

    public Direccion(String rua, String Aldea, String numero) {
        this.rua = rua;
        this.Aldea = Aldea;
        this.numero = numero;
    }

    public Direccion(String rua, String provincia, String localidade, String Aldea, String numero, String cp) {
        this.rua = rua;
        this.provincia = provincia;
        this.localidade = localidade;
        this.Aldea = Aldea;
        this.numero = numero;
        this.cp = cp;
    }
    
    

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getAldea() {
        return Aldea;
    }

    public void setAldea(String Aldea) {
        this.Aldea = Aldea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    
    
    
}
