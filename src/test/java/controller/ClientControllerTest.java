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
}