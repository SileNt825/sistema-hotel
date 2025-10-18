package sistemaRevervasHotel.models.entities;

import sistemaRevervasHotel.models.enums.StatusReverva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private StatusReverva statusReverva;

    public Reserva(){
    }

    public Reserva(Hospede hospede, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut, StatusReverva statusReverva) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.statusReverva = statusReverva;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public StatusReverva getStatusReverva() {
        return statusReverva;
    }

    public void setStatusReverva(StatusReverva statusReverva) {
        this.statusReverva = statusReverva;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Reserva{" +
                "hospede=" + hospede +
                ", quarto=" + quarto.getNumero() +
                ", dataCheckIn=" + dataCheckIn.format(fmt) +
                ", dataCheckOut=" + dataCheckOut.format(fmt) +
                ", statusReverva=" + statusReverva +
                '}';
    }
}
