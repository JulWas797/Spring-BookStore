package io.github.julwas797.bookstore.util.serialization;

import java.util.HashMap;

public interface SerializationUtil<K, V> {
    String serializeHashMap(HashMap<K, V> input);

    HashMap<K, V> deserializeHashMap(String input);
}
