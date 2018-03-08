package com.cfs.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;


/**
 * @author chopra
 * 08/03/18
 */

public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER;
    private static final ObjectMapper NON_EMPTY_OBJECT_MAPPER;
    private static final ObjectMapper NON_NULL_OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        NON_NULL_OBJECT_MAPPER = new ObjectMapper();
        NON_EMPTY_OBJECT_MAPPER = new ObjectMapper();
        NON_NULL_OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        NON_EMPTY_OBJECT_MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    public static <T> String serialize(T object) throws JsonProcessingException {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw e;
        }
    }

    public static <T> String serializeWithNonNull(T object) throws JsonProcessingException {
        try {
            return NON_NULL_OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw e;
        }
    }

    public static <T> String serialize(T object, Class view) throws JsonProcessingException {
        try {
            return OBJECT_MAPPER.writerWithView(view).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw e;
        }
    }

    public static <T> T deserialize(String json, Class<T> clazz) throws IOException {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw e;
        }
    }

    public static <T> T deserialize(String json, Class<T> clazz, Class view) throws IOException {
        try {
            return OBJECT_MAPPER.readerWithView(view).forType(clazz).readValue(json);
        } catch (IOException e) {
            throw e;
        }
    }

    public static <T> T deserializeIgnoringEmptyValues(String json, Class<T> clazz, Class view) throws IOException {
        try {
            return NON_EMPTY_OBJECT_MAPPER.readerWithView(view).forType(clazz).readValue(json);
        } catch (IOException e) {
            throw e;
        }
    }

    public static <T> List<T> deserializeToList(String json, Class<T> clazz) throws IOException {
        try {
            return OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw e;
        }
    }
}
