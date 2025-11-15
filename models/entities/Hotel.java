package sistemaRevervasHotel.models.entities;

import sistemaRevervasHotel.models.enums.StatusReverva;
import sistemaRevervasHotel.models.enums.tipoDeQuarto;


import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Hotel {
    private String nome;
    private final List<Quarto> quartos = new ArrayList<>();
    private final List<Reserva> reservas = new ArrayList<>();
    private final List<Avaliacao> avaliacoes = new ArrayList<>();
    private Reserva reserva;

    public Hotel() {
        // inicializa alguns quartos de exemplo
        quartos.add(new Quarto(101, tipoDeQuarto.SOLTEIRO.toString(), 150.0));
        quartos.add(new Quarto(102, tipoDeQuarto.CASAL.toString()   , 200.0));
        quartos.add(new Quarto(103, tipoDeQuarto.LUXO.toString(), 350.0));
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

                Reserva novaReserva = new Reserva(hospede, q, dataCheckIn, dataCheckOut, StatusReverva.CONFIRMADA);
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
    public void adicionarAvaliacao(Scanner sc){
        System.out.println("===Fazer avaliaçao===");

        System.out.println("Digite o cpf do hospede");
        String cpf = sc.nextLine();

        Reserva reserva = buscarReservaPorHospede(cpf);
        if(reserva == null){
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }
        int nota = 0;
        while(nota < 1 || nota > 5) {
            System.out.println("Nos avalie com nota de 1 a 5");
            nota = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Digite um comentário (opcional)");
        String comentario = sc.nextLine();

        Avaliacao avaliacao = new Avaliacao(
                reserva.getHospede(),
                reserva.getQuarto(),
                nota,
                comentario
        );
        avaliacoes.add(avaliacao);
        System.out.println("Avaliação registrada com sucesso");

    }

    public void listarAvaliacoes(){
        if(avaliacoes.isEmpty()){
            System.out.println("Não ha avaliações cadastradas.");
            return;
        }



            for(Avaliacao avaliacao : avaliacoes){
                String nomeHospede = "Hospede Desconhecido";
                if(avaliacao.getHospede() != null && avaliacao.getHospede().getNome() != null) {
                    nomeHospede = avaliacao.getHospede().getNome();
                }
                String quartoInfo = "não encontrado";
                if(avaliacao.getQuarto() != null) {
                    quartoInfo = String.valueOf(avaliacao.getQuarto().getNumero());
                }
                System.out.println("Avaliação de " + nomeHospede);
                System.out.println("Quarto: " + quartoInfo);
                System.out.println("Nota: " + avaliacao.getNota());
                System.out.println("Comentário: " + avaliacao.getComentario());
                System.out.println("----------------------------------------");
            }
        }
    }








