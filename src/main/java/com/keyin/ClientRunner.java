package com.keyin;

import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;

public class ClientRunner {
    public static void main(String[] args) {

        // make a switch statement here to take in commandline arguments ***********************************************

        HTTPRestCLIApplication cliApp = new HTTPRestCLIApplication();

        cliApp.setRestClient(new RESTClient());

        System.out.println();

        cliApp.generateAircraftReport();

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        cliApp.generateAirportReport();

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        cliApp.generateCityReport();

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        cliApp.generatePassengerReport();

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        // this also show the relationship, aircraft to airports
        cliApp.getAircraftByIdReport(1);

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        cliApp.getAirportByIdReport(1);

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        // relationship to show all airports in a city
        cliApp.getAirportsByCityIdReport(1);

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        cliApp.getCityByIdReport(2);

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        cliApp.getPassengerByIdReport(2);

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        // relationship to show aircraft's a passenger has been on
        cliApp.getAircraftPassengerBeenOnReport(2);

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        // relationship to show airports a passenger has visited
        cliApp.getAirportPassengerVisitedReport(1);


    }
}
