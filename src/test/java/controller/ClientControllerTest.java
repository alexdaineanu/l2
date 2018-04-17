package controller;

import model.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.DataManager;

import java.io.PrintWriter;

import static org.junit.Assert.*;

public class ClientControllerTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter writer = new PrintWriter("client.txt");
        writer.print("");
        writer.close();
        writer = new PrintWriter("issue.txt");
        writer.print("");
        writer.close();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addClientValid() {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController();
        assertEquals(ctrl.AddClient("a", "a", "1"), null);
    }

    @Test
    public void addClientInvalid() {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController();
        ctrl.AddClient("a", "a", "1");
        assertNotEquals(ctrl.AddClient("a", "a", "1"), null);
    }

    @Test
    public void addClientIndexValid() {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController();
        ctrl.AddClient("a", "a", "1");
        Client client = new Client("a", "a", "1");
        assertEquals(ctrl.AddClientIndex(client, 2018, 10, 100), "Index added");
    }

    @Test
    public void addClientIndexInvalid() {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController();
        ctrl.AddClient("a", "a", "1");
        Client client = new Client("a", "a", "1");
        assertNotEquals(ctrl.AddClientIndex(client, 2018, 0, 100), "Index added");
    }

    @Test
    public void emptyAddress() {
        ClientController ctrl = new ClientController();
        String name = "Ana";
        String address = "";
        String id = "1";
        assertEquals(ctrl.ValidateClient(name, address, id), "Name or address cannot be empty!");
    }

    @Test
    public void emptyName() {
        ClientController ctrl = new ClientController();
        String name = "";
        String address = "Gigel";
        String id = "2";
        assertEquals(ctrl.ValidateClient(name, address, id), "Name or address cannot be empty!");
    }

    @Test
    public void emptyId() {
        ClientController ctrl = new ClientController();
        String name = "Ana";
        String address = "Gigel";
        String id = "";
        assertEquals(ctrl.ValidateClient(name, address, id), null);
    }

    @Test
    public void addClientIndexYearInvalid() {
        ClientController ctrl = new ClientController();
        String name = "Ana";
        String address = "Gigel";
        String id = "";
        Client client = new Client(name, address, id);
        ctrl.AddClient(name, address, id);
        assertEquals(ctrl.AddClientIndex(client, 20199, 11, 100), "Invalid year format");
    }

    @Test
    public void addClientIndexMonthInvalid() {
        ClientController ctrl = new ClientController();
        String name = "Ana";
        String address = "Gigel";
        String id = "";
        Client client = new Client(name, address, id);
        ctrl.AddClient(name, address, id);
        assertEquals(ctrl.AddClientIndex(client, 2019, 111, 100), "Invalid month format");
    }

    @Test
    public void addClientIndexPayInvalid() {
        ClientController ctrl = new ClientController();
        String name = "Ana";
        String address = "Gigel";
        String id = "";
        Client client = new Client(name, address, id);
        ctrl.AddClient(name, address, id);
        assertEquals(ctrl.AddClientIndex(client, 2019, 11, -100), "Money to pay can't be less than 0");
    }

    @Test
    public void addClientIndexClientNotExists() {
        ClientController ctrl = new ClientController();
        String name = "Ana";
        String address = "Gigel";
        String id = "";
        Client client = new Client(name, address, id);
        assertEquals(ctrl.AddClientIndex(client, 2019, 11, 100), "Client does not exists!");
    }

    @Test
    public void addClientIndexValid2() {
        ClientController ctrl = new ClientController();
        String name = "Ana";
        String address = "Gigel";
        String id = "";
        Client client = new Client(name, address, id);
        ctrl.AddClient(name, address, id);
        assertEquals(ctrl.AddClientIndex(client, 2019, 11, 100), "Index added");
    }

}