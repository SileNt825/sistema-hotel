package sistemaRevervasHotel.application;

import sistemaRevervasHotel.models.entities.*;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Program {

    public static DateTimeFormatter getFormatter(){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        SistemaLogin login = new SistemaLogin();

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== Sistema de Reservas ===");
            System.out.println("1 - Listar quartos disponíveis");
            System.out.println("2 - Registrar conta");
            System.out.println("3 - Fazer login");
            System.out.println("4 - Fazer reserva");
            System.out.println("5 - Cancelar reserva");
            System.out.println("6 - Listar reservas");
            System.out.println("7 - listar usuários");
            System.out.println("8 - Fazer logout");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int escolherNumeroParaSistemaDeReservas = sc.nextInt();
            sc.nextLine();


            switch (escolherNumeroParaSistemaDeReservas) {
                case 1:
                    hotel.listarQuartosDisponiveis();
                    break;
                case 2:
                    System.out.println("Digite o email para cadastro: ");
                    String email = sc.nextLine();
                    System.out.println("Digite sua senha: ");
                    String senha = sc.nextLine();
                    User usuario = new User(email, senha);
                    login.registrarUsuario(usuario);
                    break;

                case 3:
                    System.out.println("Digite o email cadastrado: ");
                    String emailCadastrado = sc.nextLine();
                    System.out.println("Digite sua senha cadastrada: ");
                    String senhaCadastrada = sc.nextLine();
                    login.autenticar(emailCadastrado, senhaCadastrada);
                    break;

                case 4:
                    System.out.println("Digite o nome do hóspede: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o CPF do hóspede: ");
                    String cpf = sc.nextLine();
                    Hospede hospede = new Hospede(nome, cpf);

                    System.out.println("Digite o numero do quarto: ");
                    int numeroQuarto = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite a data de check-in (dd/MM/yyyy)");
                    LocalDate dataCheckIn = LocalDate.parse(sc.nextLine(), getFormatter());

                    System.out.println("Digite a data de check-out (dd/MM/yyyy)");
                    LocalDate dateCheckOut = LocalDate.parse(sc.nextLine(), getFormatter());

                    hotel.fazerReserva(hospede, numeroQuarto, dataCheckIn, dateCheckOut);
                    break;

                case 5:
                    System.out.println("Digite o CPF do hóspede para cancelar a reserva: ");
                    String cpfCancelar = sc.nextLine();
                    Reserva reserva = hotel.buscarReservaPorHospede(cpfCancelar);
                    hotel.cancelarReserva(reserva);
                    break;

                case 6:
                    hotel.listarReservas();
                    break;

                case 7:
                    login.listarUsuarios();
                    break;

                case 8:
                    login.logout();
                    break;

                case 0:
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");


                    sc.close();
                    System.out.println("Sistema encerrado.");

            }
        }
    }
}
