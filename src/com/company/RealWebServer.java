package com.company;

public class RealWebServer implements AbstractWebServer {
    private RequestHandler firstHandler;


    public RealWebServer(RequestHandler firstHandler) {
        this.firstHandler = firstHandler;

    }

    public RealWebServer() {
    }

    public RequestHandler getFirstHandler() {
        return firstHandler;
    }

    public void setFirstHandler(RequestHandler firstHandler) {
        this.firstHandler = firstHandler;
    }

    public void getRequest(WebRequest request) {
        firstHandler.handleRequest(request);

    }


}
