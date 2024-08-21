# Kafka Client 

Kafka Client인 Consumer와 Producer를 사용하기 위해서 Apache Kafka **라이브러리**를 추가해야 한다. 
- 라이브러리는 Gradle이나 Maven 같은 도구를 사용하여 편리하게 가져올 수 있다. 

> Kafka Client를 dependency로 잡을 때 주의할 점은 버전이다.
> - Kafka는 Broker 버전과 Client 버전의 하위호환성이 완벽하게 모든 버전에 대해서 지원하지 않는다. 
> - 일부 Kafka Broker 버전은 특정 Kafka Client 버전을 지원하지 않을 수도 있다. 
> 
> 반드시 Broker와 Client 버전의 하위호환성에 알맞는 Kafka 버전을 사용해야 한다. 

