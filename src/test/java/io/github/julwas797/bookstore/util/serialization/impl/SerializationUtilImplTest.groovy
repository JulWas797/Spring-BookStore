package io.github.julwas797.bookstore.util.serialization.impl

import spock.lang.Specification

class SerializationUtilImplTest extends Specification {

    def serializationUtils = new SerializationUtilImpl<String, Integer>()
    def deserialized = ["1": 2, "3": 4]
    def serialized = '{"1":2,"3":4}'

    def "HashMap should be Serialized properly (SerializeHashMap method)"() {
        given: "A HashMap with String and Integer pairs"
        def map = deserialized
        and: "A String containing expected output put thru URLEncoder"
        def expected = URLEncoder.encode serialized, "UTF-8"
        when: "The HashMap is serialized with SerializationUtil"
        def result = serializationUtils.serializeHashMap map
        then: "It should be serialized properly"
        result == expected
    }

    def "HashMap should be Serialized properly (DeserializeHashMap method)"() {
        given: "A serialized HashMap put thru URLDecoder"
        def map = URLDecoder.decode serialized, "UTF-8"
        and: "A HashMap containing expected output"
        def expected = deserialized
        when: "The serialized HashMap is deserialized with SerializationUtil"
        def result = serializationUtils.deserializeHashMap map
        then: "It should be deserialied properly"
        result == expected
    }
}
