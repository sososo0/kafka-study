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


> [데브원영] : 아파치 카프카 for beginners를 참고하였습니다. 
