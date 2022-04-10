package za.ac.mycput.Repository.Admin.impl;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.mycput.Entity.Admin;
import za.ac.mycput.Factory.AdminFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminRepositoryTest
{
    private static AdminRepository repository = AdminRepository.getRepository();
    private static Admin admin = AdminFactory.createAdmin("Brad", "Raatz", "0662686801", "02");
    private static Admin admin2 = AdminFactory.createAdmin("Duren", "Witbooi", "0662686802", "03");


    @Test
    public void a_Create() {
        Admin Create = repository.create(admin);
        assertEquals(admin.getAdminID(), Create.getAdminID());
        System.out.println("Created: " + Create);
    }

    @Test
    public void b_Read() {
        Admin Create = repository.create(admin2);
        Admin adminRead = repository.read(Create.getAdminID());
        assertNotNull(Create.getAdminID(), admin2.getAdminID());
        System.out.println("Read: " + adminRead);
    }


    @Test
    public void c_Update() {
        Admin update = repository.create(admin);
        Admin adminUpdate = new Admin.Builder().copy(admin)
                .setAdminPhoneNumber("0662866012")
                .build();
        adminUpdate = repository.update(adminUpdate);
        System.out.println("Old: " + admin);
        System.out.println("Updated Phone Number : " + adminUpdate);
    }


    @Test
    public void d_Delete() {
        Admin Delete = repository.create(admin);
        repository.delete(Delete.getAdminID());
        System.out.println("Deleted: " + Delete.getAdminID());
    }


    @Test
    public void e_GetAll() {
        System.out.println(repository.getAll());
    }
}