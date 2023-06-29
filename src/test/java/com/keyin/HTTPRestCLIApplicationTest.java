package com.keyin;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.domain.City;
import com.keyin.domain.Passenger;
import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Test Aircraft Report")
    public void testGenerateAircraftReport(){
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

        List<Airport> landTakeOffList1 = new ArrayList<>();
        landTakeOffList1.add(airport1);
        landTakeOffList1.add(airport2);

        List<Airport> landTakeOffList2 = new ArrayList<>();
        landTakeOffList1.add(airport1);

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

        List<Aircraft> aircraftList = new ArrayList<>();
        aircraftList.add(aircraft1);
        aircraftList.add(aircraft2);

        Mockito.when(mockRESTClient.getAllAircraft()).thenReturn(aircraftList);
        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAircraftReport().contains("Boeing 747"));
        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAircraftReport().contains("Airbus 767"));
        Assertions.assertFalse(httpRestCLIApplicationUnderTest.generateAircraftReport().contains("Newfoundland"));
    }

    @Test
    @DisplayName("Test Airport Report")
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

        List<Airport> airportList = new ArrayList<Airport>();
        airportList.add(airport1);
        airportList.add(airport2);

        Mockito.when(mockRESTClient.getAllAirport()).thenReturn(airportList);
        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAirportReport().contains("M0X S0Q"));
        Assertions.assertFalse(httpRestCLIApplicationUnderTest.generateAirportReport().contains("random airport name"));

    }

    @Test
    @DisplayName("Test City Report")
    public void testGenerateCityReport(){
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        City city1 = new City();
        city1.setId(1);
        city1.setName("St. John's");
        city1.setProvince("Newfoundland");
        city1.setPopulation(300000);

        City city2 = new City();
        city2.setId(2);
        city2.setName("Edmonton");
        city2.setProvince("Alberta");
        city2.setPopulation(3000000);

        City city3 = new City();
        city3.setId(3);
        city3.setName("Calgary");
        city3.setProvince("Alberta");
        city3.setPopulation(2000000);

        List<City> cityList = new ArrayList<>();
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        Mockito.when(mockRESTClient.getAllCity()).thenReturn(cityList);
        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateCityReport().contains("Calgary"));
        Assertions.assertFalse(httpRestCLIApplicationUnderTest.generateCityReport().contains("random city name"));
    }

    @Test
    @DisplayName("Test Passenger Report")
    public void testGeneratePassengerReport(){
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        Passenger passenger1 = new Passenger();
        passenger1.setId(1);
        passenger1.setFirstname("Kyle");
        passenger1.setLastName("Snow");
        passenger1.setPhoneNumber("(709)666-4444");

        Passenger passenger2 = new Passenger();
        passenger2.setId(2);
        passenger2.setFirstname("Ken");
        passenger2.setLastName("Chafe");
        passenger2.setPhoneNumber("(709)777-9073");

        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(passenger1);
        passengerList.add(passenger2);

        Mockito.when(mockRESTClient.getAllPassenger()).thenReturn(passengerList);
        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generatePassengerReport().contains("Ken"));
        Assertions.assertFalse(httpRestCLIApplicationUnderTest.generatePassengerReport().contains("random name"));

    }


}
