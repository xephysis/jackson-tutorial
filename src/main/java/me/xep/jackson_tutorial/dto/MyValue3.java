package me.xep.jackson_tutorial.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

//https://www.thecuriousdev.org/lombok-builder-with-jackson/
//https://stackoverflow.com/a/48801237
@Value
@Builder(builderClassName = "MyValue3TestBuilder", toBuilder = true)
@JsonDeserialize(builder = MyValue3.MyValue3TestBuilder.class)
public class MyValue3 {

    @JsonPOJOBuilder(withPrefix = "")
    public static class MyValue3TestBuilder {

    }

    private String name;
    private int age;
}
