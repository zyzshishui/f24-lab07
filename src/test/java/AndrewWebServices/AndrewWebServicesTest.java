package AndrewWebServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;


public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        database = new InMemoryDatabase(); // We probably don't want to access our real database...
        recommender = new RecSysStub();
//        promoService = new PromoService();
        promoService = mock(PromoService.class);
        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }

    @Test
    public void testLogIn() {
        assertTrue(andrewWebService.logIn("Scotty", 17214));
        assertFalse(andrewWebService.logIn("Scotty", 11111));
        assertFalse(andrewWebService.logIn("UnknownUser", 12345));
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
        assertEquals("Inception", andrewWebService.getRecommendation("Alice"));
        assertEquals("The Matrix", andrewWebService.getRecommendation("Bob"));
        assertEquals("Default Movie", andrewWebService.getRecommendation("UnknownUser"));
//        RecSys recommender = mock(RecSys.class);
//        when(recommender.getRecommendation("Scotty")).thenReturn("Animal House");
//
//        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
        String testEmail = "test@example.com";

        andrewWebService.sendPromoEmail(testEmail);

        verify(promoService, times(1)).mailTo(testEmail);
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?

        andrewWebService.logIn("Scotty", 17214);
        verifyNoInteractions(promoService);
    }
}
