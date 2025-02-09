class DatabaseStorage implements EmployeeStorage{
    public void save(Employee employee){
        System.out.println("Saving employee " + employee.getName() + "to the database");
            
    }
}