package com.transform;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Object> specs = JsonUtils.classpathToList("/jsoinfiles/misc_spec.json");

        Chainr chainr = Chainr.fromSpec(specs);
        Object inputJSON =  JsonUtils.classpathToObject("/jsoinfiles/misc_input.json");
        Object transformedOutput = chainr.transform(inputJSON);

        System.out.println(JsonUtils.toPrettyJsonString(transformedOutput));
    }
}