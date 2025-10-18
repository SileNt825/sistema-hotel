package sistemaRevervasHotel.application;

import sistemaRevervasHotel.models.entities.Hospede;
import sistemaRevervasHotel.models.entities.Hotel;
import sistemaRevervasHotel.models.entities.Reserva;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static DateTimeFormatter getFormatter(){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== Sistema de Reservas ===");
            System.out.println("1 - Listar quartos disponíveis");
            System.out.println("2 - Fazer reserva");
            System.out.println("3 - Cancelar reserva");
            System.out.println("4 - Listar reservas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int escolherNumeroParaSistemaDeReservas = sc.nextInt();
            sc.nextLine();

            Hotel hotel = new Hotel();
            switch (escolherNumeroParaSistemaDeReservas) {
                case 1:
                    hotel.listarQuartosDisponiveis();
                    break;

                case 2:
                    System.out.println("Digite o nome do hóspede: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o CPF do hóspede: ");
                    String cpf = sc.nextLine();
                    Hospede hospede = new Hospede();

                    System.out.println("Digite o numero do quarto: ");
                    int numeroQuarto = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite a data de check-in (dd/MM/yyyy)");
                    LocalDate dataCheckIn = LocalDate.parse(sc.nextLine(), getFormatter());

                    System.out.println("Digite a data de check-out (dd/MM/yyyy)");
                    LocalDate dateCheckOut = LocalDate.parse(sc.nextLine(), getFormatter());

                    hotel.fazerReserva(hospede, numeroQuarto, dataCheckIn, dateCheckOut);
                    break;

                case 3:
                    System.out.println("Digite o CPF do hóspede para cancelar a reserva: ");
                    String cpfCancelar = sc.nextLine();
                    Reserva reserva = hotel.buscarReservaPorHospede(cpfCancelar);
                    hotel.cancelarReserva(reserva);
                    break;

                case 4:
                    hotel.listarReservas();
                    break;

                case 5:
                    rodando = false;

                default:
                    System.out.println("Opção inválida!");

                    sc.close();
                    System.out.println("Sistema encerrado.");

            }
        }
    }
}
