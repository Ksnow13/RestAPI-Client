package com.keyin.http.cli;

import com.keyin.domain.*;
import com.keyin.http.client.RESTClient;

import java.util.List;

public class HTTPRestCLIApplication {

    private RESTClient restClient;

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }
        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    // Aircraft methods
    public String generateAircraftReport() {
        List<Aircraft> aircraftList = getRestClient().getAllAircraft();
        StringBuffer report = new StringBuffer();

        for (Aircraft aircraft : aircraftList) {
            report.append(aircraft.getType());
            report.append(" - ");
            report.append(aircraft.getAirlineName());

            if (aircraftList.indexOf(aircraft) != (aircraftList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All aircraft's");
        System.out.println(report.toString());
        return report.toString();
    }

    public String getAircraftByIdReport(int id) {
        Aircraft aircraft = getRestClient().getAircraftById(id);
        StringBuffer report = new StringBuffer();
        report.append(aircraft.getType());
        report.append(" - ");
        report.append(aircraft.getAirlineName());
        if (aircraft.getType() != null ) {
            System.out.println("Aircraft with id: " + id);
            System.out.println(report.toString());
        } else {
            System.out.println("There are no aircraft's with id: " + id);
        }

        return report.toString();
    }

    //------------------------------------------------------------------------------------------------------------------
    // Airport methods

    public String generateAirportReport() {
        List<Airport> airportList = getRestClient().getAllAirport();
        StringBuffer report = new StringBuffer();

        for (Airport airport : airportList) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getAreaCode());

            if (airportList.indexOf(airport) != (airportList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All airports");
        System.out.println(report.toString());
        return report.toString();
    }

    public String getAirportByIdReport(int id) {
        Airport airport = getRestClient().getAirportById(id);
        StringBuffer report = new StringBuffer();
        report.append(airport.getName());
        report.append(" - ");
        report.append(airport.getAreaCode());
        if (airport.getName() != null) {
            System.out.println("Airport with id: " + id);
            System.out.println(report.toString());
        } else {
            System.out.println("There are no airports with id: " + id);
        }

        return report.toString();
    }

    public String getAirportsByCityIdReport(int id) {
        List<Airport> airportList = getRestClient().getAirportsByCityId(id);
        StringBuffer report = new StringBuffer();

        for (Airport airport : airportList) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getAreaCode());

            if (airportList.indexOf(airport) != (airportList.size() - 1)) {
                report.append(", ");
            }
        }
        if(report.length() <= 0){
            System.out.println("There are no airports in the city with id: " + id);
        } else {
            System.out.println("All airports in the city with id: " + id);
            System.out.println(report.toString());
        }
        return report.toString();
    }

    //------------------------------------------------------------------------------------------------------------------
    // City methods

    public String generateCityReport() {
        List<City> cityList = getRestClient().getAllCity();
        StringBuffer report = new StringBuffer();

        for (City city : cityList) {
            report.append(city.getName());
            report.append(" - ");
            report.append(city.getProvince());

            if (cityList.indexOf(city) != (cityList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All cities");
        System.out.println(report.toString());
        return report.toString();
    }

    public String getCityByIdReport(int id) {
        City city = getRestClient().getCityById(id);
        StringBuffer report = new StringBuffer();
        report.append(city.getName());
        report.append(" - ");
        report.append(city.getProvince());
        if (city.getName() != null){
            System.out.println("City with id: " + id);
            System.out.println(report.toString());
        } else {
            System.out.println("There is not city with id: " + id);
        }
        return report.toString();
    }

    //------------------------------------------------------------------------------------------------------------------
    // Passenger methods

    public String generatePassengerReport() {
        List<Passenger> passengerList = getRestClient().getAllPassenger();
        StringBuffer report = new StringBuffer();

        for (Passenger passenger : passengerList) {
            report.append(passenger.getFirstname() + " " + passenger.getLastName());
            report.append(" - ");
            report.append(passenger.getPhoneNumber());

            if (passengerList.indexOf(passenger) != (passengerList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All passengers");
        System.out.println(report.toString());
        return report.toString();
    }

    public String getPassengerByIdReport(int id) {
        Passenger passenger = getRestClient().getPassengerById(id);
        StringBuffer report = new StringBuffer();
        report.append(passenger.getFirstname() + " " + passenger.getLastName());
        report.append(" - ");
        report.append(passenger.getPhoneNumber());

        if (passenger.getFirstname() != null){
            System.out.println("Passenger with id: " + id);
            System.out.println(report.toString());
        } else {
            System.out.println("There is no passenger with id: " + id);
        }

        return report.toString();
    }

    public String getAircraftPassengerBeenOnReport(int id) {
        List<Aircraft> aircraftList = getRestClient().getAircraftPassengerBeenOn(id);
        StringBuffer report = new StringBuffer();

        for (Aircraft aircraft : aircraftList) {
            report.append(aircraft.getType());
            report.append(" - ");
            report.append(aircraft.getAirlineName());

            if (aircraftList.indexOf(aircraft) != (aircraftList.size() - 1)) {
                report.append(", ");
            }
        }

        if(report.length() <= 0){
            System.out.println("The passenger with id: " + id + " has not been on any planes");
        } else {
            System.out.println("All aircraft's passenger with id: " + id + " has been on");
            System.out.println(report.toString());
        }

        return report.toString();
    }

    public String getAirportPassengerVisitedReport(int id) {
        List<Airport> airportList = getRestClient().getAirportPassengerVisited(id);
        StringBuffer report = new StringBuffer();

        for (Airport airport : airportList) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getAreaCode());

            if (airportList.indexOf(airport) != (airportList.size() - 1)) {
                report.append(", ");
            }
        }

        if(report.length() <= 0){
            System.out.println("The passenger with id: " + id + " has not been on any airports");
        } else {
            System.out.println("All airports passenger with id: " + id + " has visited");
            System.out.println(report.toString());
        }
        return report.toString();
    }


    //------------------------------------------------------------------------------------------------------------------
    // Actions

    public String getHistoryPeekReport() {
            History history = getRestClient().getHistoryPeek();

            StringBuffer report = new StringBuffer();
            report.append(history.getCalledMethod());
            report.append(" - ");
            report.append(history.getUrl());
            report.append(" - ");
            report.append(history.getTimestamp());

            if (history.getCalledMethod() != null){
                System.out.println("The last request made to the server");
                System.out.println(report.toString());
            } else {
                System.out.println("No requests have been made to the server yet, the history stack is empty");
            }
            return report.toString();
    }

    public String getAllHistoryReport() {
        List<History> historyList = getRestClient().getAllHistory();
        StringBuffer report = new StringBuffer();

        for (History history : historyList) {
            report.append(history.getCalledMethod());
            report.append(" - ");
            report.append(history.getUrl());
            report.append(" - ");
            report.append(history.getTimestamp());

            if (historyList.indexOf(history) != (historyList.size() - 1)) {
                report.append(", ");
            }
        }

        if (report.length() <= 0){
            System.out.println("No requests have been made to the server yet, the history stack is empty");
            System.out.println(report.toString());
        } else {
            System.out.println("All requests made to the server");
            System.out.println(report.toString());
        }
        return report.toString();
    }

    public String undoHistory() {
        History history = getRestClient().undoHistory();

        StringBuffer report = new StringBuffer();
        report.append(history.getCalledMethod());
        report.append(" - ");
        report.append(history.getUrl());
        report.append(" - ");
        report.append(history.getTimestamp());

        if (history.getCalledMethod() != null){
            System.out.println("The last request made to the server");
            System.out.println(report.toString());
        } else {
            System.out.println("cannot undo any further the history stack is empty");
        }
        return report.toString();
    }

    public String redoHistory() {
        History history = getRestClient().redoHistory();

        StringBuffer report = new StringBuffer();
        report.append(history.getCalledMethod());
        report.append(" - ");
        report.append(history.getUrl());
        report.append(" - ");
        report.append(history.getTimestamp());

        if (history.getCalledMethod() != null){
            System.out.println("The last request made to the server");
            System.out.println(report.toString());
        } else {
            System.out.println("cannot redo any further you reached the top of the history stack");
        }
        return report.toString();
    }

}

