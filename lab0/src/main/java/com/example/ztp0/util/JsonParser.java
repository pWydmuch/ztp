package com.example.ztp0.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//@Component
public class JsonParser<T> {


    public List<T> retrieveData(Class<T> contentClass, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> objectsList = null;
        JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, contentClass);
        InputStream is = TypeReference.class.getResourceAsStream(path);
        File file = new File(path);
        objectsList = objectMapper.readValue(file,type);

        return objectsList;
    }

    public void write(List<T> list, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(path), list);
    }
}