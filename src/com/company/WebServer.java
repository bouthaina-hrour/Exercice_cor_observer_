package com.company;

import java.util.ArrayList;
import java.util.List;

public class WebServer implements WebRequestObservable {
    private RequestHandler firstHandler;
    private List<WebRequestObserver> observers=new ArrayList<>();

    public WebServer(RequestHandler firstHandler) {
        this.firstHandler = firstHandler;

    }

    public WebServer() {
    }

    public RequestHandler getFirstHandler() {
        return firstHandler;
    }

    public void setFirstHandler(RequestHandler firstHandler) {
        this.firstHandler = firstHandler;
    }

    public void getRequest(WebRequest request) {
        firstHandler.handleRequest(request);
        this.notifyObservers(request);
    }

    @Override
    public void attach(WebRequestObserver observer) {
        this.observers.add(observer);

    }

    @Override
    public void detach(WebRequestObserver observer) {
        this.observers.remove(observer);

    }

    @Override
    public void notifyObservers(WebRequest webRequest) {
        for (WebRequestObserver observer : observers) {
            observer.update(webRequest);
        }

    }
}
