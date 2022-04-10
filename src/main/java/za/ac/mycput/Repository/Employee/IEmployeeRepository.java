package za.ac.mycput.Repository.Employee;

import za.ac.mycput.Entity.Employee;
import za.ac.mycput.Repository.IRepository;

import java.util.Set;

public interface IEmployeeRepository extends IRepository<Employee,String>
{
    public Set<Employee> getAll();
}
