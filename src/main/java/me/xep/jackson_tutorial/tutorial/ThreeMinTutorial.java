package me.xep.jackson_tutorial.tutorial;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.val;
import me.xep.jackson_tutorial.dto.MyValue;
import me.xep.jackson_tutorial.dto.MyValue2;
import me.xep.jackson_tutorial.dto.MyValue3;
import me.xep.jackson_tutorial.dto.MyValue4;

import java.util.HashMap;
import java.util.Map;

public class ThreeMinTutorial {

    public static void main(String args[]) throws JsonProcessingException {
        Map map = new HashMap<String, MyValue>(
                Map.of(
                        "first", MyValue.builder().name("name1").age(1).build(),
                        "second", MyValue.builder().name("name2").age(2).build()
                )
        );
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(map);

        val deserializedMap = objectMapper.readValue(jsonString, new TypeReference<Map<String, MyValue>>() {
        });
        assert deserializedMap.get("first").getName().equalsIgnoreCase("name1");
        assert deserializedMap.get("first").getAge() == 1;
        assert deserializedMap.get("second").getName().equalsIgnoreCase("name2");
        assert deserializedMap.get("second").getAge() == 2;

        val deserializedMap2 = objectMapper.readValue(jsonString, new TypeReference<Map<String, MyValue2>>() {
        });
        assert deserializedMap2.get("first").getName().equalsIgnoreCase("name1");
        assert deserializedMap2.get("first").getAge() == 1;
        assert deserializedMap2.get("second").getName().equalsIgnoreCase("name2");
        assert deserializedMap2.get("second").getAge() == 2;


        val deserializedMap3 = objectMapper.readValue(jsonString, new TypeReference<Map<String, MyValue3>>() {
        });
        assert deserializedMap3.get("first").getName().equalsIgnoreCase("name1");
        assert deserializedMap3.get("first").getAge() == 1;
        assert deserializedMap3.get("second").getName().equalsIgnoreCase("name2");
        assert deserializedMap3.get("second").getAge() == 2;

        val deserializedMap4 = objectMapper.readValue(jsonString, new TypeReference<Map<String, MyValue4>>() {
        });
        assert deserializedMap4.get("first").getName().equalsIgnoreCase("name1");
        assert deserializedMap4.get("first").getAge() == 1;
        assert deserializedMap4.get("second").getName().equalsIgnoreCase("name2");
        assert deserializedMap4.get("second").getAge() == 2;

        var root = ((ObjectNode) objectMapper.readTree(jsonString));
        var name = root.get("first").get("name").asText();
        var age = root.get("first").get("age").asInt();

        root.with("third").put("third_key", "third_value");

        String json = objectMapper.writeValueAsString(root);
        System.out.println(json);
    }
}
