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
    private int numSocio=0;
    private String nome;
    private String apelidos;
    private String dni;
    private Direccion dir;
    private String info;
    private int telefono;
    private String mail;

    /*
    *Aqui defino varios constructores pra crear o obxeto de distintas formas.
    */
    public Comuneiro(String nome, String apelidos, String dni, Direccion dir) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.dni = dni;
        this.dir = dir;
        numSocio++;
    }

    public Comuneiro(String nome, String apelidos, String dni, Direccion dir, int telefono) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.dni = dni;
        this.dir = dir;
        this.telefono = telefono;
        numSocio++;
    }

    public Comuneiro(String nome, String apelidos, String dni, Direccion dir, int telefono, String mail) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.dni = dni;
        this.dir = dir;
        this.telefono = telefono;
        this.mail = mail;
        numSocio++;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    
    
    
    
}
