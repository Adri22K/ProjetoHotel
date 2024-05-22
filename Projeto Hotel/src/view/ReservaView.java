package view;

import java.util.List;
import java.util.Scanner;

import controller.ReservaController;
import model.Reserva;

public class ReservaView {
    private ReservaController reservaController;
    private Scanner scanner;

    public ReservaView() {
        reservaController = new ReservaController();
        scanner = new Scanner(System.in);
    }

    public void displayAllReservas() {
        List<Reserva> reservas = reservaController.getAllReservas();
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getIdReservas());
            System.out.println("Data de Início: " + reserva.getDataInicio());
            System.out.println("Data de Fim: " + reserva.getDataFim());
            System.out.println("ID Hóspede: " + reserva.getIdHospedes());
            System.out.println("ID Quarto: " + reserva.getIdQuarto());
            System.out.println("-----------------------------");
        }
    }

    public void addReserva() {
        System.out.println("Digite o ID da reserva:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a data de início (yyyy-mm-dd):");
        String dataInicio = scanner.nextLine();
        System.out.println("Digite a data de fim (yyyy-mm-dd):");
        String dataFim = scanner.nextLine();
        System.out.println("Digite o ID do hóspede:");
        int idHospede = scanner.nextInt();
        System.out.println("Digite o ID do quarto:");
        int idQuarto = scanner.nextInt();

        Reserva reserva = new Reserva(id, java.sql.Date.valueOf(dataInicio), java.sql.Date.valueOf(dataFim), idHospede, idQuarto);
        reservaController.addReserva(reserva);
        System.out.println("Reserva adicionada com sucesso!");
    }

    public void updateReserva() {
        System.out.println("Digite o ID da reserva a ser atualizada:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a nova data de início (yyyy-mm-dd):");
        String dataInicio = scanner.nextLine();
        System.out.println("Digite a nova data de fim (yyyy-mm-dd):");
        String dataFim = scanner.nextLine();
        System.out.println("Digite o novo ID do hóspede:");
        int idHospede = scanner.nextInt();
        System.out.println("Digite o novo ID do quarto:");
        int idQuarto = scanner.nextInt();

        Reserva reserva = new Reserva(id, java.sql.Date.valueOf(dataInicio), java.sql.Date.valueOf(dataFim), idHospede, idQuarto);
        reservaController.updateReserva(reserva);
        System.out.println("Reserva atualizada com sucesso!");
    }

    public void deleteReserva() {
        System.out.println("Digite o ID da reserva a ser deletada:");
        int id = scanner.nextInt();
        scanner.nextLine();
        reservaController.deleteReserva(id);
        System.out.println("Reserva deletada com sucesso!");
    }
}
