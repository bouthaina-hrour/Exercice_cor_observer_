package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**and my proxy webserver is a Smart proxy that
 * add extra functionality (logging) to the calls to the real web server
 */
public class ProxyWebServer implements AbstractWebServer{
    RealWebServer realWebServer ;
    FileLogger fileLogger;

    public ProxyWebServer(FileLogger fileLogger,RealWebServer realWebServer) {
        this.realWebServer=realWebServer;
        this.fileLogger=fileLogger;

    }



    @Override
    public void getRequest(WebRequest request) {
        this.realWebServer.getRequest(request);
        if(request.getLoggedUser().isAdmin()){
            this.fileLogger.log("Request made to "+request.getPath()+" by admin user");
        }
        else
        {
            this.fileLogger.log("Request made to "+request.getPath()+" by non admin user");
        }
    }
}

