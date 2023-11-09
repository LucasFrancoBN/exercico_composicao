package exercicio_composicao;

import java.time.LocalDate;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		Worker w = new Worker("l", WorkerLevel.JUNIOR, 1.0, new Department("Front-end"));
		
		HourContract hc = new HourContract(LocalDate.now(), 1.0, 1); 
		
		w.addContract(hc);

		System.out.println(w);
		
		w.removeContract(hc);
		
		System.out.println(w);
	}

}
