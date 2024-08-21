import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) throws IOException {

        // 1. 프로듀서를 위한 설정

        // Java Property 객체를 통해 Producer의 설정을 정의
        Properties configs = new Properties();
        // 부트스트랩 서버 설정을 localhost의 kafka를 바라보도록 설정
        // - Kafka Broker의 주소 목록은 되도록이면 2개 이상의 ip와 port를 설정하도록 권장
        // - 둘 중 하나가 비정상적일 경우, 다른 정상적인 브로커에 연결되어 사용 가능하기 때문
        configs.put("bootstrap.servers", "localhost:9092");
        // Key와 Value에 대해 StringSerializer로 직렬화 설정
        // - Serializer는 Key 혹은 Value를 직렬화하기 위해 사용
        // - Byte Array, String, Integer Serializer를 사용할 수 있다.
        // Key는 메시지를 보내면, Topic의 파티션이 지정될 때 쓰인다.
        configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 설정한 Property로 Kafka Producer instance 만들기
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);

        // 전송할 객체 만들기
        // Kafka Client에서는 ProducerRecord 클래스를 제공
        // - ProducerRecord instance를 생성할 때 어느 Topic에 넣을 것인지
        // - 어떤 Key와 Value를 담을 것인지 선언할 수 있다.
        // 이 예시에서는 key 없이 click_log topic에 login이라는 value 보내기
        ProducerRecord record = new ProducerRecord<String, String>("click_log", "login");
        // 만약 Key를 포함하여 보내고 싶다면 아래 코드와 같이 record를 선언하면 된다.
        // - 파라미터 개수에 따라 자동으로 overloading되어 instance가 생성
        // ProducerRecord record = new ProducerRecord<String, String>("click_log", "1", "login");

        // record 전송하기
        producer.send(record);

        // producer 종료하기
        producer.close();
    }
}