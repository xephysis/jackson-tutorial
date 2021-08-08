package me.xep.jackson_tutorial.tutorial;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FiveMinTutorial {
    public static void main(String args[]) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("test.json");

        JsonGenerator g = objectMapper.createGenerator(jsonFile, JsonEncoding.UTF8);
        g.writeStartObject();
        g.writeStringField("message", "Hello World!!!");
        g.writeEndObject();
        g.close();

        try (JsonParser p = objectMapper.createParser(jsonFile)) {
            JsonToken t = p.nextToken();
            t = p.nextToken();
            if (t != JsonToken.FIELD_NAME || !"message".equals(p.currentName())) {
                System.out.println("error");
            }

            t = p.nextToken();
            if (t != JsonToken.VALUE_STRING) {
                System.out.println("error");
            }

            String msg = p.getText();
            System.out.println(msg);
        }
    }
}
