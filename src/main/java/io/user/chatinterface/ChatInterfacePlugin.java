package io.user.chatinterface;

import hudson.Extension;
import hudson.model.RootAction;
import jenkins.model.Jenkins;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.logging.Logger;

/**
  * Main class of the Chat Interface Plugin.
  * Implements a simple Jenkins chat interface to handle chat interface requests.
 */
@Extension
public class ChatInterfacePlugin implements RootAction {
    
    private static final Logger LOGGER = Logger.getLogger(ChatInterfacePlugin.class.getName());
    private String lastResponse;
    
    @Override
    public String getIconFileName() {
        return "chat.png";
    }
    
    @Override
    public String getDisplayName() {
        return "Chat Interface";
    }
    
    @Override
    public String getUrlName() {
        return "chat";
    }
    
    /**
     * handle chat interface requests.
     * @param req StaplerRequest object
     * @param rsp StaplerResponse object
     * @throws ServletException if a servlet exception occurs
     * @throws IOException if an IO exception occurs
     */
    public void doIndex(StaplerRequest req, StaplerResponse rsp) throws ServletException, IOException {
        try {
            Jenkins.get().checkPermission(Jenkins.READ);
            LOGGER.info("Accessing chat interface");
            req.getView(this, "index").forward(req, rsp);
        } catch (Exception e) {
            LOGGER.severe("Error in doIndex: " + e.getMessage());
            e.printStackTrace();
            rsp.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }
    
    /**
     * Gets the last response message.
     * @param req StaplerRequest object
     * @param rsp StaplerResponse ocject
     * @return The most recent response message
     */
    public HttpResponse doRespond(StaplerRequest req, StaplerResponse rsp) throws ServletException, IOException {
        try {
            LOGGER.info("Entering doRespond method");
            Jenkins.get().checkPermission(Jenkins.READ);
            
            String message = req.getParameter("message");
            LOGGER.info("Received message parameter: " + message);
            
            if (message != null && !message.trim().isEmpty()) {
                lastResponse = "get your message: " + message;
                LOGGER.info("Response set to: " + lastResponse);
            } else {
                LOGGER.warning("Received empty message");
                lastResponse = "Please enter a valid message";
            }
            
            LOGGER.info("Redirecting back to index page");
            return new HttpResponse() {
                @Override
                public void generateResponse(StaplerRequest req, StaplerResponse rsp, Object node) throws IOException, ServletException {
                    rsp.sendRedirect(".");
                }
            };
        } catch (Exception e) {
            LOGGER.severe("Error in doRespond: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * get last response
     * @return last response
     */
    public String getLastResponse() {
        return lastResponse;
    }
} 