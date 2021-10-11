package de.tech26.robotfactory.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class file to provide methods for json
 *
 * @author Tarun Rohila
 */
public class JsonUtils {

    /**
     * Variable declaration for objectMapper
     */
    private static ObjectMapper objectMapper;

    /**
     * Method to get instance of object mapper
     *
     * @return objectmapper
     */
    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }

    /**
     * Method to load Object from json
     *
     * @param path   - json path
     * @param pClass - object type
     * @param <T>    - generic
     * @return object
     */
    public static <T> T loadJsonToObj(String path, Class<T> pClass) {
        T t = null;
        ObjectMapper objectMapper = JsonUtils.getObjectMapper();
        InputStream in = pClass.getClassLoader().getResourceAsStream(path);
        try {
            t = objectMapper.readValue(in, pClass);
        } catch (IOException e) {
        }
        return t;
    }
}
