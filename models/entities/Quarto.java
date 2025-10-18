package sistemaRevervasHotel.models.entities;


public class Quarto {
    private Integer numero;
    private String tipo;
    private double precoDiaria;
    private boolean ocupado;

    public Quarto() {}

    public Quarto(int numero, String tipo, double precoDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiaria = precoDiaria;
        this.ocupado = false;
    }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getPrecoDiaria() { return precoDiaria; }
    public void setPrecoDiaria(double precoDiaria) { this.precoDiaria = precoDiaria; }

    public boolean isOcupado() { return ocupado; }
    public void setOcupado(boolean ocupado) { this.ocupado = ocupado; }

    public double calcularPrecoDiaria() {
        return precoDiaria; // você pode melhorar para calcular pelo número de dias
    }

    @Override
    public String toString() {
        String status = ocupado ? "OCUPADO" : "DISPONÍVEL";
        return "Quarto " + numero + " (" + tipo + ") - R$" + precoDiaria + " - " + status;
    }
}
