package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter departament's name: ");
        String departamentName = sc.nextLine();
        Departament departament = new Departament(departamentName);

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String stringWorkerLevel = sc.nextLine();
        WorkerLevel workerLevel = WorkerLevel.valueOf(stringWorkerLevel);
        System.out.print("Base Salary: ");
        Double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, workerLevel, baseSalary, departament);

        System.out.print("How many contracts to this worker? ");
        int numberOfContracts = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < numberOfContracts; i++){
            System.out.printf("Enter contract #%d data: %n", i + 1);

            System.out.print("Date (DD/MM/YYYY) : " );
            String stringDate = sc.nextLine();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(stringDate,fmt);

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int duration = sc.nextInt();
            sc.nextLine();
            HourContract contract = new HourContract(date, valuePerHour, duration);
            worker.addContract(contract);
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String stringIncomeDate = sc.nextLine();
        stringIncomeDate = "01/" +stringIncomeDate;
        DateTimeFormatter fmtIncomeDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate incomeDate = LocalDate.parse(stringIncomeDate,fmtIncomeDate);
        Double income = worker.income(incomeDate.getYear(), incomeDate.getMonthValue());

        System.out.print(worker);
        System.out.printf("Income for 0%d/%d : %.2f",incomeDate.getMonthValue(),incomeDate.getYear(),income);

        sc.close();
    }
}
