package microserviceTrip.controllers;

import microserviceTrip.services.TripService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class TripControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private static MockMvc mockMvc;

    @Autowired
    private TripService tripService;

    @BeforeEach
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void givenAnUrl_ReturnARandomTripName() throws Exception {
        //THEN
        mockMvc.perform(get("/getTripName"))
                .andExpect(status().isOk());
    }

    @Test
    public void givenUserPreferencesAndAttractionId_ReturnAListOfTrip() throws Exception {
        //GIVEN
        UUID attractionId = UUID.randomUUID();
        int adults = 2;
        int children = 2;
        int nightsStay = 7;
        int rewardsPoints = 200;

        //THEN
        mockMvc.perform(get("/getTripsPrices")
                        .param("attractionId", String.valueOf(attractionId))
                        .param("adults", String.valueOf(adults))
                        .param("children", String.valueOf(children))
                        .param("nightsStay", String.valueOf(nightsStay))
                        .param("rewardsPoints", String.valueOf(rewardsPoints)))
                .andExpect(status().isOk());

    }
}
