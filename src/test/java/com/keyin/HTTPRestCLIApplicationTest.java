package com.keyin;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HTTPRestCLIApplicationTest {

    @Mock
    private RESTClient mockRESTClient;

    @Test
    public void testGenerateAirportReport(){
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        Airport airport1 = new Airport();
        airport1.setId(1);
        airport1.setName("St. John's Airport");
        airport1.setAreaCode("A0A Z0A");
        airport1.setCityId(1);

        Airport airport2 = new Airport();
        airport2.setId(2);
        airport2.setName("Edmonton Airport");
        airport2.setAreaCode("M0X S0Q");
        airport2.setCityId(2);

        Airport airport3 = new Airport();
        airport3.setId(2);
        airport3.setName("Calgary Airport");
        airport3.setAreaCode("J0X R0Q");
        airport3.setCityId(2);

        List<Airport> landTakeOffList1 = new ArrayList<>();
        landTakeOffList1.add(airport1);
        landTakeOffList1.add(airport2);
        landTakeOffList1.add(airport3);

        List<Airport> landTakeOffList2 = new ArrayList<>();
        landTakeOffList1.add(airport2);
        landTakeOffList1.add(airport3);

        List<Airport> landTakeOffList3 = new ArrayList<>();
        landTakeOffList3.add(airport1);

        Aircraft aircraft1 = new Aircraft();
        aircraft1.setId(1);
        aircraft1.setType("Boeing 747");
        aircraft1.setAirlineName("Air Canada");
        aircraft1.setNumberOfPassengers(500);
        aircraft1.setAllowedAirportList(landTakeOffList1);

        Aircraft aircraft2 = new Aircraft();
        aircraft2.setId(2);
        aircraft2.setType("Airbus 767");
        aircraft2.setAirlineName("Air Canada");
        aircraft2.setNumberOfPassengers(300);
        aircraft2.setAllowedAirportList(landTakeOffList2);

        Aircraft aircraft3 = new Aircraft();
        aircraft3.setId(3);
        aircraft3.setType("Blue flyer");
        aircraft3.setAirlineName("private owned");
        aircraft3.setNumberOfPassengers(6);
        aircraft3.setAllowedAirportList(landTakeOffList3);


        List<Aircraft> aircraftList = new ArrayList<>();
        aircraftList.add(aircraft1);
        aircraftList.add(aircraft2);
        aircraftList.add(aircraft3);

        Mockito.when(mockRESTClient.getAllAircraft()).thenReturn(aircraftList);
        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertFalse(httpRestCLIApplicationUnderTest.generateAircraftReport().contains("Boeing 747"));
    }

}
