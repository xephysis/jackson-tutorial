package me.xep.jackson_tutorial.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = MyValue4.MyValue4Builder.class)
public class MyValue4 {

    @JsonPOJOBuilder(withPrefix = "")
    //이 static builder class 는 원래 lombok 이 만들어 주는 class 임
    //따로 명시한건 JsonPOJOBuilder 어노테이션을 붙이기 위해서?
    //https://projectlombok.org/features/Builder 의 With Jackson 항목 참조
    public static class MyValue4Builder {

    }

    private String name;
    private int age;
}
