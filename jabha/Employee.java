/*  "SRP violation" in this code is seen in the Employee class
because it is having both the data representation printing and 
database handling at the same class. which is 

    "OCP violation" in this code is caused by no having the 
interface . so in earlier code snippet there was no interface and it would may have caused 
problem and violated the open closed principle. late in this code i have applied interface in Employee.java
which allows to new storage implementation without modifying the code.
*/



class Employee{
    String name;
    double salary;

    Employee(String name, double salary){
        this.name=name;
        this.salary=salary;
    }

    String getName(){
        return name;
    }

    double getSalary(){
        return salary;
    }
}