package rasmus.MandeepExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getGender()
    {
        return gender;
    }

    public String getDepartment()
    {
        return department;
    }

    public int getYearOfJoining()
    {
        return yearOfJoining;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public String toString()
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
}

public class EmployeeExercises {
    public List<Employee> employeeList = new ArrayList<>();

    public EmployeeExercises(){
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
    }

    /**
     * 1. How many male and female employees are there in the organization?
     * 2. Print the name of all departments in the organization?
     * 3. What is the average age of male and female employees?
     * 4. Get the details of highest paid employee in the organization?
     * 5. Get the names of all employees who have joined after 2015?
     * 6. Count the number of employees in each department?
     * 7. What is the average salary of each department?
     * 8. Get the details of the youngest male employee in the product development department?
     * 9. Who has the most working experience in the organization?
     * 10. How many male and female employees are there in the sales and marketing team?
     * 11. What is the average salary of male and female employees?
     * 12. List down the names of all employees in each department?
     * 13. What is the average salary and total salary of the whole organization?
     * 14. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years?
     * 15. Who is the oldest employee in the organization?  What is his age and which department he belongs to?
     */
    public static void main(String[] args) {
        EmployeeExercises employees = new EmployeeExercises();

        employees.employeesByGender();
        employees.printAllDepartments();
        employees.averageAgeByGender();
        employees.highestPayedEmployee();
        employees.nameOfEmployeesWhoJoinedAfter2015();
        employees.numberOfEmployeesInEachDepartment();
    }

    private void numberOfEmployeesInEachDepartment() {

    }

    private void nameOfEmployeesWhoJoinedAfter2015() {
        System.out.println("Employees who joined after 2015:");
        employeeList.stream().filter(e -> e.getYearOfJoining() >= 2015).forEach(System.out::println);
    }

    private void highestPayedEmployee() {
        Optional<Employee> highestPayedEmployee = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Highest payed employee:");
        highestPayedEmployee.ifPresent(System.out::println);
    }

    private void averageAgeByGender() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)))
                .forEach((k, v) -> System.out.println("The average age of a " + k.toLowerCase() + " employee is " + v + " years"));
    }

    private void printAllDepartments() {
        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
    }

    private void employeesByGender() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
                .forEach((k, v) -> System.out.println("There are " + v + " " + k + " employees"));
    }

	/*
	//How many male and female employees are there in the organization?
	public void countMaleAndFemale() {
		Map<String,Long> noOfMaleAndFemaleEmployees=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(noOfMaleAndFemaleEmployees);

	}

	//> Print the name of all departments in the organization?
	public void printAllDepartmentsinOrganization() {
					employeeList
					.stream()
					.map(Employee::getDepartment)
					.distinct()
					.forEach(System.out::println);
	}

	//>What is the average age of male and female employees?
	public void averageAgeMalenFemale() {
		Map<String, Double> averageAgeMaleFemale=employeeList.stream()
														.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));

		System.out.println(averageAgeMaleFemale);
	}

	//> Get the details of highest paid employee nthe organization?
	public void highestPaidinOrganization() {
	Optional<Employee> highestPaidinOrganization=	employeeList.stream()
					.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

	Employee highestPaidEmployee = highestPaidinOrganization.get();
	System.out.println("Details Of Highest Paid Employee : ");
	System.out.println("==================================");
	System.out.println("ID : "+highestPaidEmployee.getId());
	System.out.println("Name : "+highestPaidEmployee.getName());
	System.out.println("Age : "+highestPaidEmployee.getAge());
	System.out.println("Gender : "+highestPaidEmployee.getGender());
	System.out.println("Department : "+highestPaidEmployee.getDepartment());
	System.out.println("Year Of Joining : "+highestPaidEmployee.getYearOfJoining());
	System.out.println("Salary : "+highestPaidEmployee.getSalary());
	}

	//>Get the names of all employees who have joined after 2015?
	public void joinedAfter2015() {
		employeeList.stream()
		.filter(e->e.getYearOfJoining()>2015)
		.map(Employee::getName)
		.forEach(System.out::println);

	List<Employee>	joinedAfter2015=employeeList.stream()
			.filter(e->e.getYearOfJoining()>2015)
							.collect(Collectors.toList());
		for (Employee emp:joinedAfter2015) {
			System.out.println("Employee Name" +emp.getName()+ " Year of Joining"+emp.getYearOfJoining());
		}

	}

	//Count the number of employees in each department?
	public void numberOfEmployeesinEachDepartment() {
		Map<String,Long> numberOfEmployeesPerDept=employeeList.stream()
													.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

		Set<Entry<String, Long>> entrySet = numberOfEmployeesPerDept.entrySet();

		for (Entry<String, Long> entry : entrySet)
		{
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		System.out.println(numberOfEmployeesPerDept);
	}

	//Average Salary per Department

	public void avgSalaryperDepartment() {

		Map<String,Double> avgSalaryperDepartment=employeeList.stream()
													.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

		Set<Entry<String,Double>> averageSalarySet=avgSalaryperDepartment.entrySet();

		for(Entry<String,Double> entry:averageSalarySet) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}


		System.out.println(avgSalaryperDepartment);

	}

	//Query 3.8 : Get the details of youngest male employee in the product development department?

	public void youngestMaleinProductDevelopment() {
		Optional<Employee>	youngestMaleinProductDevelopment=employeeList.stream()
							.filter(e->e.getDepartment().equals("Product Development") && e.getGender().equals("Male"))
							.min(Comparator.comparingInt(Employee::getAge));
		Employee youngestMaleinPD=youngestMaleinProductDevelopment.get();

		System.out.println("youngestMaleinProductDevelopment: " +youngestMaleinPD);

	}

	//Query 3.9 : Who has the most working experience in the organization?

	public void maxExperienceEmp() {

		Optional<Employee> maxExperience=employeeList.stream()
										.sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		Employee maxExperienceEmp=maxExperience.get();

		System.out.println("maxExperience Employee: " +maxExperienceEmp);


	}

	//Query 3.10 : How many male and female employees are there in the sales and marketing team?

	public void maleAndFemaleinSnM() {
		Map<String,Long> maleAndFemaleinSnM=employeeList.stream()
											.filter(e->e.getDepartment().equals("Sales And Marketing"))
											.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

		Set<Entry<String,Long>> maleandFemaleinSalesAndMarketing=maleAndFemaleinSnM.entrySet();

		for (Entry<String,Long> entry:maleandFemaleinSalesAndMarketing) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}

	}

	//Query 3.11 : What is the average salary of male and female employees?
	public void averageSalaryMaleandFemale() {
		Map<String,Double> averageSalaryMaleandFemale=employeeList
														.stream()
														.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("Average Salary of Men and Women" +averageSalaryMaleandFemale);
	}


	//Query 3.12 : List down the names of all employees in each department?
	public void employeeAndDepartment() {
	Map<String,List<Employee>> employeeAndDepartment=employeeList.stream()
													.collect(Collectors.groupingBy(Employee::getDepartment));

	Set<Entry<String,List<Employee>>> employeesPerDepartment=employeeAndDepartment.entrySet();
			for (Entry<String,List<Employee>> entry:employeesPerDepartment) {
				System.out.println("Department : "+entry.getKey()+" And their employess: ");
				for(Employee emp:entry.getValue()) {
					System.out.println(emp);
				}
			}
		}

	//Query 3.13 : What is the average salary and total salary of the whole organization?

	public void averageSalaryandTotalSalary() {
		DoubleSummaryStatistics employeeSalaryStatistics=
				employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());

		System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());

		Double averageSalary=employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("Average Salary = "+averageSalary);
	}

	//Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.

	public void overAndUnder25() {
		Map<Boolean,List<Employee>> overAndUnder25=employeeList.stream().collect(Collectors.partitioningBy(e->e.getAge()>25));

		Set<Entry<Boolean,List<Employee>>> experienceMap25=overAndUnder25.entrySet();

		for(Entry<Boolean,List<Employee>>entry:experienceMap25) {


			if(entry.getKey()) {
				System.out.println("Employees Older Than 25");
			}else
			{
				System.out.println("Employees younger than or equal to 25 years :");
			}

			System.out.println("----------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list)
			{
				System.out.println(e.getName());
			}
		}
		}
	//Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
	public void oldestEmp() {
		Optional<Employee> oldestEmp=employeeList.stream()
									 .max(Comparator.comparingInt(Employee::getAge));
		Employee oldestEmployee = oldestEmp.get();

		System.out.println("Name : "+oldestEmployee.getName());

		System.out.println("Age : "+oldestEmployee.getAge());

		System.out.println("Department : "+oldestEmployee.getDepartment());
	}
	*/

}