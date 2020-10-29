package ohtuesimerkki;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elmaneva
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void OikeiaPelaajaLoytyy() {
        Player pelaaja = stats.search("Semenko");
        String nimi = pelaaja.getName();
        assertEquals("Semenko", nimi);
    }
    
    @Test
    public void FeikkipelaajaPalauttaaNull() {
        assertNull(stats.search("Elma"));
    }
    
    @Test
    public void LoytaaJoukkueen() {
        Player pelaaja = stats.team("EDM").get(0);
        String nimi = pelaaja.getName();
        assertEquals("Semenko", nimi);
    }
    
    @Test
    public void LoytaaParhaatPelaajat() {
        Player pelaaja = stats.topScorers(3).get(0);
        String nimi = pelaaja.getName();
        System.out.println(nimi);
        assertEquals("Gretzky", nimi);
    }
}
