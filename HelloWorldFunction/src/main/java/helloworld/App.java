package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.tp.udemy.aws.lambda.Coordinator;
import com.tp.udemy.aws.lambda.Payment;
import com.tp.udemy.aws.lambda.TicketDetails;

/**
 * Handler for requests to Lambda function.
 */
public class App {

    public void getTruckTracker(Coordinator coordinator){
        System.out.println("Longitude "+ coordinator.getLongitude());
        System.out.println("Latitude "+ coordinator.getLatitude());
    }

    public TicketDetails getTicker(Payment payment) throws Exception {
        TicketDetails ticket = new TicketDetails();
        if (payment.getAmount() > 100 && payment.getAmount() < 300){
            ticket.setAdresse("NY DC");
            ticket.setBusNumber("NB8890");
        } else if (payment.getAmount() > 400 && payment.getAmount() < 800) {
            ticket.setAdresse("ON UIO");
            ticket.setBusNumber("OP009");
        }else if (payment.getAmount() > 600 && payment.getAmount() < 889) {
            ticket.setAdresse("KI 990");
            ticket.setBusNumber("KO 887");
        }else {
            throw new Exception("Not adress exist or payment insufficient!!!");
        }
        return ticket;
    }
}
