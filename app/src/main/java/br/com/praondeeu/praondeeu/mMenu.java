package br.com.praondeeu.praondeeu;

public class mMenu extends Contato {
    private int id;
    private String nome,categoria,tipo,foto,fllib;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFllib() {
        return fllib;
    }

    public void setFllib(String fllib) {
        this.fllib = fllib;
    }
}
