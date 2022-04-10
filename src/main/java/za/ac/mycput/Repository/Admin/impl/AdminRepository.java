package za.ac.mycput.Repository.Admin.impl;
/*
    Author : Devon Sherwyn May
    Student number : 219168296
    Date : 10 April 2022
    AdminRepository.Java
*/
import za.ac.mycput.Entity.Admin;
import za.ac.mycput.Repository.Admin.IAdminRepository;

import java.util.HashSet;
import java.util.Set;

public class AdminRepository implements IAdminRepository {
    private static AdminRepository repository = null;
    private Set<Admin> adminDB = null;

    private AdminRepository() {
        adminDB = new HashSet<Admin>();
    }

    public static AdminRepository getRepository() {
        if (repository == null)
        {
            repository = new AdminRepository();
        }
        return repository;
    }

    @Override
    public Admin create(Admin admin)
    {
        boolean success = adminDB.add(admin);
        if(!success)
            return null;
        return admin;
    }

    @Override
    public Admin read(String adminID)
    {
        for (Admin a : adminDB)
        {
            if(a.getAdminID().equals(adminID))
                return a;
        }
        return null;
    }

    @Override
    public Admin update(Admin admin)
    {
        Admin oldAdmin = read(admin.getAdminID());
        if (oldAdmin!=null)
        {
            adminDB.remove(oldAdmin);
            adminDB.add(admin);
            return admin;
        }
        return null;
    }

    @Override
    public boolean delete(String adminID)
    {
        Admin adminToDelete = read(adminID);
        if(adminToDelete == null)
            return false;
        adminDB.remove(adminToDelete);
        return true;
    }

    @Override
    public Set<Admin> getAll() {
        return adminDB;
    }
}
