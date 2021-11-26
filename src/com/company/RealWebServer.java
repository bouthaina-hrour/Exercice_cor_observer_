package com.company;
/**
 * my realWebServer is a webServer that have only a request handler to assure the chain of
 * responsability pattern made before*/
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
