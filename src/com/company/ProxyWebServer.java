package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProxyWebServer implements AbstractWebServer{
    RealWebServer realWebServer ;
    String filePath;

    public ProxyWebServer(String filePath,RealWebServer realWebServer) {
        this.realWebServer=realWebServer;

        this.filePath = filePath;
        try {
            Files.deleteIfExists(Paths.get(this.filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void log(String msg) {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(this.filePath, true));
            out.println(msg);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void getRequest(WebRequest request) {
        this.realWebServer.getRequest(request);
        if(request.getLoggedUser().isAdmin()){
            this.log("Request made to "+request.getPath()+" by admin user");
        }
        else
        {
            this.log("Request made to "+request.getPath()+" by non admin user");
        }
    }
}

