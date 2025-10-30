package model;

public class Bicicleta {
    private Integer id_bicicleta;
    private String codigo;
    private String marca;
    private String color;
    private String tamaño;
    private Double precio;
    private Integer estado;

    public Bicicleta(String codigo, String marca, String color, String tamaño, Double precio, Integer estado) {
        this.codigo = codigo;
        this.marca = marca;
        this.color = color;
        this.tamaño = tamaño;
        this.precio = precio;
        this.estado = estado;
    }

    public Bicicleta(Integer id_bicicleta, String codigo, String marca, String color, String tamaño, Double precio, Integer estado) {
        this.id_bicicleta = id_bicicleta;
        this.codigo = codigo;
        this.marca = marca;
        this.color = color;
        this.tamaño = tamaño;
        this.precio = precio;
        this.estado = estado;
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

    public Double getPrecio() {
        return precio;
    }

    public Integer getEstado() {
        return estado;
    }

    public String getEstadoTexto() {
        return estado == 1 ? "Disponible" : "No Disponible";
    }
}
