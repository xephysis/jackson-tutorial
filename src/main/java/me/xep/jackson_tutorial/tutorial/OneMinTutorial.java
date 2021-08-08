package me.xep.jackson_tutorial.tutorial;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.xep.jackson_tutorial.dto.MyValue;

public class OneMinTutorial {
    public static void main(String args[]) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        MyValue value = objectMapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyValue.class);

        System.out.println(value);

        String jsonString = objectMapper.writeValueAsString(value);
        System.out.println(jsonString);
    }
}
