package exercicio_composicao;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Enter department's name: ");
		String departmentInput = sc.nextLine();
		Department department = new Department(departmentInput);

		System.out.println("Enter worker data:");
		System.out.print("Name: ");

		String workerName = sc.nextLine();
		System.out.print("Level: ");

		WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();

		System.out.println();
		System.out.print("How many contracts to this worker? ");
		int amountOfContracts = sc.nextInt();

		HourContract[] contracts = new HourContract[amountOfContracts];

		for(int i = 0; i < contracts.length; i++) {
			System.out.printf("Enter contract #%d%n data: ", i + 1);
			System.out.print("DD/MM/YYYY");
			sc.nextLine();
			LocalDate date = LocalDate.parse(sc.nextLine());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();

			contracts[i] = new HourContract(date, valuePerHour, hours);
		}

		Worker worker = new Worker(workerName, level, baseSalary, department);

		for(HourContract contract : contracts) {
			worker.addContract(contract);
		}

		System.out.print("Enter and year to calculate income (MM/YYYY): ");
		sc.nextLine();
		String dateIncome = sc.nextLine();
		System.out.println(worker.income(dateIncome));


	}

}
