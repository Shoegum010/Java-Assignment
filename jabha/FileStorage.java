class FileStorage implements EmployeeStorage{
    void save(Employee employee){
        System.out.println("Saving Employee " + employee.getName() " to the file .");
    }
}