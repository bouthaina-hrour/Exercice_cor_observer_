package com.company;

public class ExistingContentCheckRequestHandler extends RequestHandler {
    @Override
    public void handleRequest(WebRequest webRequest) {
        if (!webRequest.getPath().equals("/dashboard")&& !webRequest.getPath().equals("/home")){
            System.out.println("Status 404 : Page missing");
        }
        else
        {
            this.successorHandleRequest(webRequest);
        }


    }
}
