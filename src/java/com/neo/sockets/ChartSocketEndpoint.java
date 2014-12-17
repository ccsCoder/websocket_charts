package com.neo.sockets;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import com.google.gson.*;
import com.neo.datasource.ChartDataSource;
/**
 *
 * @author neo
 */
@ServerEndpoint("/chartServer")
public class ChartSocketEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session.getId() + " has opened a connection");
    }

    /**
     * When a user sends a message to the server, this method will intercept the
     * message and allow us to react to it. For now the message is read as a
     * String.
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        
        //System.out.println("Message from " + session.getId() + ": " + new Gson().toJson(ChartDataSource.getWeeklyWorkData()));
        try {
            //System.out.println("Sending ..."+ new Gson().toJson(ChartDataSource.getWeeklyWorkData()));
            //session.getBasicRemote().sendText(new Gson().toJson(ChartDataSource.getWeeklyWorkData()));
            Gson gson = new Gson();
            
            //System.out.println();
            while(true) {
                for(Session s: session.getOpenSessions()) {
                    s.getBasicRemote().sendText(gson.toJson(ChartDataSource.getWeeklyWorkData()));
                }
                
                Thread.sleep(5000);
            }
        } catch (Exception ex) {
            System.out.println("OOPS !!!!");
            ex.printStackTrace();
        }
    }

    /**
     * The user closes the connection.
     *
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("Session " + session.getId() + " has ended");
    }

}
