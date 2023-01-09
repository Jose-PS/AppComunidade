/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Clase pra gardar os datos de cada comuneiro
 * @author Jose PS
 */
public class Comuneiro {
    private int numSocio;
    private String nome;
    private String apelidos;
    private String dni;
    private Direccion dir;
    private String info;
    private String telefono;
    private String mail;

    /*
    *Aqui defino varios constructores pra crear o obxeto de distintas formas.
    */
    public Comuneiro(String nome, String apelidos, String dni, Direccion dir) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.dni = dni;
        this.dir = dir;
    }

    public Comuneiro(String nome, String apelidos, String dni, Direccion dir, String telefono) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.dni = dni;
        this.dir = dir;
        this.telefono = telefono;
    }

    public Comuneiro(String nome, String apelidos, String dni, Direccion dir, String telefono, String mail) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.dni = dni;
        this.dir = dir;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Comuneiro(int numSocio, String nome, String apelidos, String dni, Direccion dir, String info, String telefono, String mail) {
        this.numSocio = numSocio;
        this.nome = nome;
        this.apelidos = apelidos;
        this.dni = dni;
        this.dir = dir;
        this.info = info;
        this.telefono = telefono;
        this.mail = mail;
    }
    
    

    public int getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Direccion getDir() {
        return dir;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Comuneiro{" + "numSocio=" + numSocio + ", nome=" + nome + ", apelidos=" + apelidos + ", dni=" + dni + ", info=" + info + ", telefono=" + telefono + ", mail=" + mail + '}';
    }

    
    
    
    
}
