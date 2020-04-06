package com.okta.lambdatest;

public class HandlerResponse {
    public boolean isBase64Encoded = false;
    public int statusCode = 200;
    public String headers = "";
    public String multiValueHeaders = null;
    public String body = "";
    HandlerResponse(int statusCode, String body, String headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
    }
}
