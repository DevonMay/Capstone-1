package za.ac.mycput.Repository.Admin;

import za.ac.mycput.Entity.Admin;
import za.ac.mycput.Repository.IRepository;

import java.util.Set;

public interface IAdminRepository extends IRepository<Admin,String>
{
    public Set<Admin> getAll();
}
