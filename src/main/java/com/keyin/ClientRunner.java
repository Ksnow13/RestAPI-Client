package com.keyin;

import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;

public class ClientRunner {
    public static void main(String[] args) {

        // make a switch statement here to take in commandline arguments ***********************************************

        HTTPRestCLIApplication cliApp = new HTTPRestCLIApplication();

        cliApp.setRestClient(new RESTClient());

        /*

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

         */


        if (args.length > 0) {

            switch (args[0]) {

                // Aircraft commands
                case "aircraft":
                    cliApp.generateAircraftReport();
                    break;
                case "aircraftById":
                    cliApp.getAircraftByIdReport(Integer.parseInt(args[1]));
                    break;

                // Airport commands
                case "airport":
                    cliApp.generateAirportReport();
                    break;
                case "airportById":
                    cliApp.getAirportByIdReport(Integer.parseInt(args[1]));
                    break;
                case "airportByCityId":
                    cliApp.getAirportsByCityIdReport(Integer.parseInt(args[1]));
                    break;

                // City commands
                case "city":
                    cliApp.generateCityReport();
                    break;
                case "cityById":
                    cliApp.getCityByIdReport(Integer.parseInt(args[1]));
                    break;

                // Passenger commands
                case "passenger":
                    cliApp.generatePassengerReport();
                    break;
                case "passengerById":
                    cliApp.getPassengerByIdReport(Integer.parseInt(args[1]));
                    break;
                case "passengerAircraft":
                    cliApp.getAircraftPassengerBeenOnReport(Integer.parseInt(args[1]));
                    break;
                case "passengerAirport":
                    cliApp.getAirportPassengerVisitedReport(Integer.parseInt(args[1]));
                    break;

                // History commands
                case "history":
                    cliApp.getHistoryPeekReport();
                    break;
                case "allHistory":
                    cliApp.getAllHistoryReport();
                    break;
                case "undoHistory":
                    cliApp.getUndoHistory();
                    break;
                case "redoHistory":
                    cliApp.getRedoHistory();
                    break;
                default:
                    System.out.println();
                    System.out.println("** Sorry, Unknown args **");
            }
        } else {
            System.out.println();
            System.out.println("** You must edit configuration and add arguments to access data ** ");
        }

    }
}
