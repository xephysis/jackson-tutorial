package me.xep.jackson_tutorial.tutorial;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TenMInTutorial {

    public static class IgnoreTest {

        private String name;

        @JsonProperty("name")
        public String getTheName() {
            return name;
        }

        //setter 에는 안 걸어줘도 따라가는데 왜지
        // note: it is enough to add annotation on just getter OR setter;
        // so we can omit it here
        //라고는 하는데
        public void setTheName(String n) {
            this.name = n;
        }
    }

    @JsonIgnoreProperties({"foo", "bar"})
    public static class IgnoreTest2 {

        @JsonIgnore
        public String internal;

        public String external;

        private int _code;

        @JsonIgnore
        public void setCode(int c) { _code = c; }

        // note: will also be ignored because setter has annotation!
        public int getCode() { return _code; }

        private int code2;
        public void setCode2(int c) { code2 = c; }
        public int getCode2() { return code2; }
    }

    public static void main0(String args[]) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        IgnoreTest ignoreTest = new IgnoreTest();
        ignoreTest.setTheName("test_name");

        String jsonString = objectMapper.writeValueAsString(ignoreTest);
        System.out.println(jsonString);

        IgnoreTest obj = objectMapper.readValue(jsonString, IgnoreTest.class);
        System.out.println(obj);
    }
    public static void main(String args[]) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        IgnoreTest2 ignoreTest2 = new IgnoreTest2();
        ignoreTest2.internal = "internal_value";
        ignoreTest2.external = "external_value";
        ignoreTest2.setCode(1);
        ignoreTest2.setCode2(2);

        String jsonString = objectMapper.writeValueAsString(ignoreTest2);
        //{"external":"external_value","code2":2}
        System.out.println(jsonString);

        IgnoreTest2 obj = objectMapper.readValue(jsonString, IgnoreTest2.class);
        System.out.println(obj);

        String testString = "{\"internal\":\"internal_value\",\"external\":\"external_value\",\"code\":1,\"code2\":2}";
        IgnoreTest2 obj2 = objectMapper.readValue(testString, IgnoreTest2.class);
        System.out.println(obj2);
    }
}
