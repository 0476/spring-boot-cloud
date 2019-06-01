package com.ailikes.auth.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.base.Preconditions;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public JsonUtils() {
    }

    public static ObjectMapper getMapper() {
        return objectMapper;
    }

    public static String serialize(Object object) throws IOException {
        return serialize(object, false);
    }

    public static String serialize(Object object, boolean withPretty) throws IOException {
        Writer write = new StringWriter();
        if (withPretty) {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(write, object);
        } else {
            objectMapper.writeValue(write, object);
        }

        return write.toString();
    }

    public static String serialize(ObjectMapper objectMapper, Object object, boolean withPretty) throws IOException {
        Writer write = new StringWriter();
        if (withPretty) {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(write, object);
        } else {
            objectMapper.writeValue(write, object);
        }

        return write.toString();
    }

    public static <T> T deserialize(String json, Class<T> classType) throws IOException {
        Preconditions.checkNotNull(json);
        return (T) objectMapper.readValue(json, TypeFactory.rawClass(classType));
    }

    public static <T> T deserialize(String json, TypeReference<T> typeRef) throws IOException {
        return objectMapper.readValue(json, typeRef);
    }

    public static <T> T deserialize(ObjectMapper objectMapper, String json, TypeReference<T> typeRef) throws IOException {
        return objectMapper.readValue(json, typeRef);
    }

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}