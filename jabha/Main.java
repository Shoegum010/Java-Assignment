public class Main{
    public static void main(string[] args){
        Employee empl =new Employee("Sugam Rai", 70000);

        PrintPaySlip print = new PrintPaySlip();
        printer.PrintPaySlip(empl);

        EmployeeStorage storage = new DatabaseStorage();
        storage.save(empl);
    }
}