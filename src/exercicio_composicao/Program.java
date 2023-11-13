package exercicio_composicao;

import java.time.LocalDate;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		Worker w = new Worker("l", WorkerLevel.JUNIOR, 1.0, new Department("Front-end"));
		
		HourContract hc = new HourContract(LocalDate.now(),  8.0, 7);
		HourContract hc2 = new HourContract(LocalDate.parse("2023-07-15"), 15.0, 35);
		HourContract hc3 = new HourContract(LocalDate.parse("2023-08-15"), 5.0, 3);
		HourContract hc4 = new HourContract(LocalDate.parse("2023-05-15"), 50.0, 50);
		HourContract hc5 = new HourContract(LocalDate.parse("2023-08-15"), 5.0, 3);

		w.addContract(hc);

		System.out.println(w);
		
		w.removeContract(hc);

		w.addContract(hc2);
		w.addContract(hc3);
		w.addContract(hc4);
		w.addContract(hc5);
		
		System.out.println(w);
		System.out.println(w.income(2023, 8));
	}

}
