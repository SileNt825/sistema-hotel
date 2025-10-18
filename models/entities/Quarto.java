package sistemaRevervasHotel.models.entities;

import sistemaRevervasHotel.models.enums.tipoDeQuarto;

public class Quarto {
    private Integer numero;
    private tipoDeQuarto quarto;
    private double precoDaDiaria;
    private boolean ocupado;

    public Quarto(){
    }

    public Quarto(Integer numero, tipoDeQuarto quarto, double precoDaDiaria, boolean ocupado) {
        this.numero = numero;
        this.quarto = quarto;
        this.precoDaDiaria = precoDaDiaria;
        this.ocupado = ocupado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public tipoDeQuarto getQuarto() {
        return quarto;
    }

    public void setQuarto(tipoDeQuarto quarto) {
        this.quarto = quarto;
    }

    public double getPrecoDaDiaria() {
        return precoDaDiaria;
    }

    public void setPrecoDaDiaria(double precoDaDiaria) {
        this.precoDaDiaria = precoDaDiaria;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", quarto=" + quarto +
                ", precoDaDiaria= R$" + precoDaDiaria +
                ", " + (ocupado ? "Ocupado" : "Disponível" + "}");

    }
}

