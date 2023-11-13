package entities;

import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private List<HourContract> contracts = new ArrayList<>();
	private final Department department;
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public String income(String date) {
		String[] monthAndYear = date.split("/");
		LocalDate dateUser = LocalDate.parse(monthAndYear[1] + "-" + monthAndYear[0] + "-" + "01");
		List<HourContract> filterByDate = contracts.stream().filter(list -> list.getDate().isAfter(dateUser)).toList();
		Double reduceValue = 0.0;

		for(HourContract contract : filterByDate) {
			reduceValue += contract.totalValue();
		}

		return "Name: " + this.name + "\n" +
				"Department: " + this.department + "\n" +
				"Income for " + date + ": " + reduceValue;
	}

	public Department getDepartment() {
		return department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
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
