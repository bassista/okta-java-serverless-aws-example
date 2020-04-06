package com.okta.lambdatest;
import com.amazonaws.services.lambda.runtime.Context;
import java.util.Map;

public class Handler2 {
    public String requestHandler(Map<String, String> map, Context context)
    {
        String value  = map.get("key");
        return value;
    }
}
