package model;

public class Bicicleta {
    private Integer id_bicicleta;
    private String codigo;
    private String marca;
    private String color;
    private String tamaño;

    public Bicicleta(String codigo, String marca, String color, String tamaño) {
        this.codigo = codigo;
        this.marca = marca;
        this.color = color;
        this.tamaño = tamaño;
    }

    public Bicicleta(Integer id_bicicleta, String codigo, String marca, String color, String tamaño) {
        this.id_bicicleta = id_bicicleta;
        this.codigo = codigo;
        this.marca = marca;
        this.color = color;
        this.tamaño = tamaño;
    }

    public Integer getId_bicicleta() {
        return id_bicicleta;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public String getTamaño() {
        return tamaño;
    }
}
