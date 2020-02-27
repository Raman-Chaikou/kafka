package com.kafka;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer<>(kafkaProps);


        int i = 10;
        while(i > 0) {
            ProducerRecord<String, String> record =
        new ProducerRecord<String,String>("Customer", "Products", "France" + i);
            Future response = producer.send(record);
            System.out.println(response.get().toString());
            i--;
        }

    }
}
