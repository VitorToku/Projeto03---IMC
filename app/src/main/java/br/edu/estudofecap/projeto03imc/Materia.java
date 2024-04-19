package br.edu.estudofecap.projeto03imc;

import java.io.Serializable;

public class Materia implements Serializable {
    String nomeMateria;
    Double ni, pi, po;

    public Materia(String nomeMateria, Double ni, Double pi, Double po) {
        this.nomeMateria = nomeMateria;
        this.ni = ni;
        this.pi = pi;
        this.po = po;
    }

    public Materia(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public Double getNi() {
        return ni;
    }

    public void setNi(Double ni) {
        this.ni = ni;
    }

    public Double getPi() {
        return pi;
    }

    public void setPi(Double pi) {
        this.pi = pi;
    }

    public Double getPo() {
        return po;
    }

    public void setPo(Double po) {
        this.po = po;
    }
}
