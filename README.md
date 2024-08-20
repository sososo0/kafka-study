# kafka

![img.png](imgs/img.png)

- Kafka는 Source Application과 Target Application의 결합(coupling)을 약하게 하기 위해 나왔다.
- Source Application은 Kafka에 데이터를 전송하고, Target Application은 Kafka에서 Data를 가져오면 된다. 
- Source Application은 쇼핑몰의 클릭 로그, 결제 로그와 같은 데이터를 보낼 수 있다. 
- Target Application은 로그 적재, 로그 처리등의 역할을 한다. 
- Source Application에서 보낼 수 있는 데이터 포맷은 거의 제한이 없다. 

![img.png](imgs/img1.png)

- Kafka는 각종 데이터를 담는 Topic이라는 개념이 있는데, 쉽게 말하면 Queue이다.  
- Queue에 데이터를 넣는 역할은 Producer가 하고, Queue에 데이터를 가져가는 역할은 Consumer가 한다. 
- Producer와 Consumer는 라이브러리로 되어있어서, 애플리케이션에서 구현이 가능하다. 

> Kafka는 fault tolerant(고가용성)으로 서버 이슈가 생기거나 갑작스럽게 렉(전원이) 내려간다거나 하는 상황에서도 데이터를 손실 없이 복구할 수 있다.
> 또한, 낮은 지연(latency)과 높은 처리량(throughput)을 통해 아주 효과적으로 데이터를 아주 많이 처리할 수 있다.
> 빅데이터를 처리할 때 Kafka를 많이 쓴다. 

## Kafka, RabbitMQ, Redis Queue 

메세징 플랫폼은 2가지로 나뉜다. 

1. 메시지 브로커 
  - 메시지 브로커는 많은 기업들에서 대규모 메시지 기반 미들웨어 아키텍처에서 사용되어왔다. 
    - 미들웨어라는 것은 서비스하는 애플리케이션들을 보다 효율적으로 아키텍처들을 연결하는 요소들로 작동하는 SW를 뜻한다. 
    - 메시징 플랫폼, 인증 플랫폼, 데이터베이스 같은 것들이 미들웨어이다. 
  - 메시지 브로커에 있는 큐에 데이터를 보내고 받는 프로듀서와 컨슈머를 통해 메시지를 통신하고 네트워크를 맺는 용도로 사용해왔다. 
  - 메시지 브로커의 특징으로는 메시지를 받아서 적절히 처리하고 나면 즉시 또는 짧은 시간 내에 삭제되는 구조이다. 
2. 이벤트 브로커 
   - 메시지 브로커와 조금 다른 구조로 만들어져 있다. 
   - 이벤트 브로커는 2가지 특징이 있다.
     - 이벤트 또는 메시지라고 불리는 레코드를 딱 하나만 보관하고 인덱스를 통해 개별 액세스를 관리한다. 
     - 업무상 필요한 시간동안 이벤트를 보존할 수 있다. 

메시지 브로커는 이벤트 브로커로 역할을 할 수 없지만, 이벤트 브로커는 메시지 브로커 역할을 할 수 있다.

> 메시지 브로커는 데이터를 보내고, 처리하고 삭제한다.
> 이벤트 브로커는 데이터를 삭제하지 않는다.

##### 이벤트 브로커는 왜 데이터를 삭제하지 않을까? 

이는 '이벤트'라는 키워드를 보면 된다. 

- 이벤트 브로커는 서비스에서 나오는 이벤트를 데이터베이스에 저장하듯이 이벤트 브로커의 큐에 저장한다. 
  - 이는 딱 한번 일어난 이벤트 데이터를 브로커에 저장함으로써 단일 진실 공급원으로 사용할 수 있다. 
  - 또한, 장애가 발생했을 때 장애가 일어난 시점부터 재처리할 수 있다. 
  - 마지막으로, 많은 양의 실시간 스트림 데이터들을 효과적으로 처리할 수 있다는 특징이 있다. 

메시지 브로커는 RabbitMQ, Redis Queue, 이벤트 브로커는 Kafka나 AWS의 키네시스가 대표적이다. 

따라서, 이벤트 브로커로 클러스터를 구축하면 이벤트 기반 마이크로 서비스 아키텍처로 발전하는데 아주 중요한 역할을 할 뿐만 아니라 메시지 브로커의 역할도 할 수 있다. 


> [데브원영] : 아파치 카프카 for beginners를 참고하였습니다. 
