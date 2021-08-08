package me.xep.jackson_tutorial.dto;

import lombok.*;

//일단 lombok 을 통해 기본생성자, 전체 생성자 포함하면 동작
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class MyValue {
    private String name;
    private int age;
}
