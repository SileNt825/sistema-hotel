package sistemaRevervasHotel.models.entities;

import sistemaRevervasHotel.models.enums.StatusReverva;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nome;
    private List<Quarto> quartos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(String nome, List<Quarto> quartos, List<Reserva> reservas) {
        this.nome = nome;
        this.quartos = quartos;
        this.reservas = reservas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void removerQuarto(Quarto quarto) {
        quartos.remove(quarto);
    }

    public boolean estaDisponivel(Quarto quarto, LocalDate checkIn, LocalDate checkOut) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().equals(quarto) && !(checkOut.isBefore(reserva.getDataCheckIn()) || checkIn.isAfter(reserva.getDataCheckOut()))) {
                return false;
            }
        }
        return true;
    }

    public void fazerReserva(Hospede hospede, int numeroQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut, Quarto quartoSelecionado) {

        if(!estaDisponivel(quartoSelecionado, dataCheckIn, dataCheckOut)){
            System.out.println("Quarto indisponível nesse período!");

        }

        quartoSelecionado = null;

        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                quartoSelecionado = quarto;
                break;
            }
        }

        if (quartoSelecionado == null) {
            System.out.println("Quarto não encontrado");

        }

        Reserva novaReserva = new Reserva(hospede, quartoSelecionado, dataCheckIn, dataCheckOut, StatusReverva.PENDENTE);
        reservas.add(novaReserva);

        quartoSelecionado.setOcupado(true);

        System.out.println("Reserva criada com sucesso!");
    }

    public void cancelarReserva(Reserva reserva) {
        if (reserva == null) {
            System.out.println("Reserva cancelada;");
            return;
        }
            reserva.setStatusReverva(StatusReverva.CANCELADA);
            reserva.getQuarto().setOcupado(false);

            System.out.println("Reserva cancelada com sucesso");

        }

        public void listarReservas(){
            if(reservas.isEmpty()){
                System.out.println("nenhuma reserva encontrada. ");
                return;
            }

            for(Reserva reserva : reservas){
                System.out.println(reserva);
            }
        }

        public Reserva buscarReservaPorHospede(String cpf){
            for(Reserva reserva : reservas){
                Hospede hospede = reserva.getHospede();
                if(hospede.getCpf().equals(cpf)){
                    return reserva;
                }
            }
            System.out.println("Nenhuma reserva encontrada.");
            return null;
        }

        public void listarQuartosDisponiveis(){

        for(Quarto quarto: quartos){
            if(!quarto.isOcupado()){
                System.out.println("Quarto disponível " + quarto);

            } else {
                System.out.println("Quarto indisponível.");
            }
        }
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nome='" + nome + '\'' +
                ", quartos=" + quartos.size() +
                ", reservas=" + reservas.size() +
                '}';
    }

    public void fazerReserva(Hospede hospede, int numeroQuarto, LocalDate dataCheckIn, LocalDate dateCheckOut) {
    }
}






