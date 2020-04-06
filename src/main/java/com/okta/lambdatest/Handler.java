package com.okta.lambdatest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.text.ParseException;
import java.util.Map;
import java.util.stream.Collectors;

// Handler value: example.Handler


public class Handler implements RequestStreamHandler {

  Gson gson = new GsonBuilder().serializeNulls().create();

  @Override
  public void handleRequest(
          InputStream inputStream,
          OutputStream outputStream,
          Context context)
          throws IOException {


    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    LambdaLogger logger = context.getLogger();

    String input = reader.lines().collect(Collectors.joining());

    logger.log("INPUT: " + input);

    try {

      JSONParser parser = new JSONParser();
      JSONObject event = (JSONObject) parser.parse(reader);

      HandlerResponse response = new HandlerResponse(200, "You said: " + input, null);
      String json = gson.toJson(response);
      OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
      writer.write(json);
      writer.close();

    } catch (Exception ex) {
      HandlerResponse response = new HandlerResponse(400, "ERROR: " + ex.getMessage(), null);
      String json = gson.toJson(response);
      OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
      writer.write(json);
      writer.close();
    }


  }
}


