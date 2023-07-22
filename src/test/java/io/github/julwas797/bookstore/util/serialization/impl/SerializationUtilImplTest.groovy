package io.github.julwas797.bookstore.util.serialization.impl

import spock.lang.Specification

import javax.persistence.EntityManager
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

class SerializationUtilImplTest extends Specification {

    def serializationUtils = new SerializationUtilImpl<String, Integer>()

    def "hashmap should serialize properly (SerializeHashMap method)"() {
        given: "a HashMap with String and Integer pairs"
            def map = ["1":2,"3":4]
        when: "the HashMap is serialized with SerializationUtil"
            def result = serializationUtils.serializeHashMap map
        then:

    }

//    def "DeserializeHashMap"() {
//    }
}
