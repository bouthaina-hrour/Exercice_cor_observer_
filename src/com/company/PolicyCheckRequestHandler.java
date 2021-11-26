package com.company;

public class PolicyCheckRequestHandler extends RequestHandler {
    @Override
    public void handleRequest(WebRequest webRequest) {
        if(webRequest.getPath().equals("/dashboard")&& !webRequest.getLoggedUser().isAdmin()){
            System.out.println("Status 403 : user is not authorized to access this content");
        }
        else
        {
            this.successorHandleRequest(webRequest);
        }
    }
}
