package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private List<HourContract> contracts = new ArrayList<HourContract>();
	private Department department;
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}	
	
	
	public Double income(Integer year, Integer month) {
		LocalDate dateUser = LocalDate.parse(year + "-" + month + "-" + "01");
		
		List<HourContract> filterByDate = contracts.stream().filter(list -> dateUser.isAfter(dateUser)).toList();
		
		Double reducedValues = filterByDate.stream().reduce(0.0, (acc, actual) -> acc.totalValue() + actual.totalValue());
		
		return 0.0;
	}
	
	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", contracts=" + contracts
				+ ", department=" + department + "]";
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
}
