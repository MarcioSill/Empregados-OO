package application;

import java.text.Format;
import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Nome do departamento: ");
		String dep = sc.nextLine();
		
		System.out.print("Dia do pagamento: ");
		int dias = sc.nextInt();
		
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Telefone:");
		String phone = sc.nextLine();
		
		Department department = new Department(dep, dias, new Address(email, phone));
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			System.out.println("Dados do funcionário " + i + ":");
			
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee(nome, salary);
			department.addEmployee(employee);
		}
		
	    System.out.println();
		
		showReport(department);
				
		sc.close();
	}

	private static void showReport(Department department) {
		
		System.out.println("FOLHA DE PAGAMENTO:");
		
		System.out.println("Departamento "+department.getName()+ " = R$ "+ String.format("%.2f", department.payroll()));
		System.out.println("Pagamento realizado no dia "+ department.getPayDay());
		
		System.out.println("Funcionários:");
		
		for(Employee c : department.getEmployee()) {
			System.out.println(c.getName());
		}
		
		System.out.println("Para dúvidas favor entrar em contato: " + department.getAddress().getEmail());
		System.out.println("Telefone: " + department.getAddress().getPhone());
		
	}

}
