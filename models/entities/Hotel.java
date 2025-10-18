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
        // inicializa alguns quartos de exemplo
        quartos.add(new Quarto(101, "Solteiro", 150.0));
        quartos.add(new Quarto(102, "Casal", 200.0));
        quartos.add(new Quarto(103, "Luxo", 350.0));
    }

    public void listarQuartosDisponiveis() {
        System.out.println("\n=== Lista de Quartos ===");
        for (Quarto q : quartos) {
            System.out.println(q);
        }
    }

    public boolean estaDisponivel(Quarto quarto, LocalDate checkIn, LocalDate checkOut) {
        for (Reserva r : reservas) {
            if (r.getQuarto().equals(quarto) &&
                    !(checkOut.isBefore(r.getDataCheckIn()) || checkIn.isAfter(r.getDataCheckOut()))) {
                return false;
            }
        }
        return true;
    }

    public void fazerReserva(Hospede hospede, int numeroQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numeroQuarto) {

                if (!estaDisponivel(q, dataCheckIn, dataCheckOut) || q.isOcupado()) {
                    System.out.println("Quarto indisponível!");
                    return;
                }

                Reserva novaReserva = new Reserva(hospede, q, dataCheckIn, dataCheckOut, StatusReverva.PENDENTE);
                reservas.add(novaReserva);
                q.setOcupado(true);

                System.out.println("Reserva criada com sucesso!");
                return;
            }
        }
        System.out.println("Quarto não encontrado!");
    }

    public void cancelarReserva(Reserva reserva) {
        if (reserva == null) {
            System.out.println("Reserva não encontrada!");
            return;
        }
        reserva.setStatusReverva(StatusReverva.CANCELADA);
        reserva.getQuarto().setOcupado(false);
        System.out.println("Reserva cancelada com sucesso!");
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }
        System.out.println("\n=== Reservas Atuais ===");
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    public Reserva buscarReservaPorHospede(String cpf) {
        for (Reserva r : reservas) {
            if (r.getHospede().getCpf().equals(cpf)) {
                return r;
            }
        }
        return null;
    }
}






