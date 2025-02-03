import java.util.Scanner;

class Employee {
    int empNo;
    String empName;
    String dept;
    String designation;
    int basic;
    int hra;
    int it;
    int da;

    Employee(int empNo, String empName, String dept, String designation, int basic, int hra, int it, int da) {
        this.empNo = empNo;
        this.empName = empName;
        this.dept = dept;
        this.designation = designation;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
        this.da = da;
    }

    int calculateSalary() {
        return basic + hra + da - it;
    }
}

public class Experiment1 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(1001, "Ashish", "R&D", "Engineer", 20000, 8000, 3000, 20000),
                new Employee(1002, "Sushma", "PM", "Consultant", 30000, 12000, 9000, 32000),
                new Employee(1003, "Rahul", "Acct", "Clerk", 10000, 8000, 1000, 12000),
                new Employee(1004, "Chahat", "Front Desk", "Receptionist", 12000, 6000, 2000, 15000),
                new Employee(1005, "Ranjan", "Engg", "Manager", 50000, 20000, 20000, 40000),
                new Employee(1006, "Suman", "Manufacturing", "Engineer", 23000, 9000, 4400, 20000),
                new Employee(1007, "Tanmay", "PM", "Consultant", 29000, 12000, 10000, 32000)
        };

        Scanner in = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int empId = in.nextInt();
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.empNo == empId) {
                found = true;
                System.out.println("Emp No. Emp Name Department Designation Salary");
                System.out.println(emp.empNo + " " + emp.empName + " " + emp.dept + " " + emp.designation + " " + emp.calculateSalary());
                break;
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid: " + empId);
        }

        in.close();
    }
}
