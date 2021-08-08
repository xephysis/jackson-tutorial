package me.xep.jackson_tutorial.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Setter
@Getter
public class MyValue2 {

    /**
     * 얘는 JsonCreator 쓰는 목적이 뭐지
     */
    @JsonCreator
    public MyValue2(@JsonProperty("name") String name, @JsonProperty("age") int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;
}
