/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Pra non sobrecargar a clase comuneiro, meto aqui os datos da direccion
 * @author DAW
 */
public class Direccion {
    private String rua;
    private String provincia;
    private String localidade;
    private int numero;
    private int cp;

    public Direccion(String rua, String provincia, String localidade, int numero, int cp) {
        this.rua = rua;
        this.provincia = provincia;
        this.localidade = localidade;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
    
    
}
