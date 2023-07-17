package io.github.julwas797.bookstore;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Service
public class SerializationUtilImpl<K, V> implements SerializationUtil<K, V> {

    private static final String CHAR_TO_REPLACE = "\"";
    private static final String CHAR_REPLACEMENT = "%20";
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    @SneakyThrows
    public String serializeHashMap(HashMap<K, V> input) {
        return URLEncoder.encode(mapper.writeValueAsString(input), StandardCharsets.UTF_8);
    }

    @Override
    @SneakyThrows
    public HashMap<K, V> deserializeHashMap(String input) {
        var typeRef = new TypeReference<HashMap<K, V>>() {
        };
        var decoded = URLDecoder.decode(input, StandardCharsets.UTF_8);
        return mapper.readValue(decoded, typeRef);
    }
}
