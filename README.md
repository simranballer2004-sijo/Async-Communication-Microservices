how async communication takes place in microservices ..


orderService -> Message Broker(kafka) -> stock service 
Step 1.  We need to create order Service , stock service , main domain service  Micro services 
Step 2. In Domain service : create 2 DTO’s  -> order , orderEvent 
	order will consist -> price, name , quantity etc
	orderEvent will consist of -> message, status and Order 

Step 3. In OrderService (which is the producer
		3.1 Initialize application properties with kafka configs and topic name etc.
		3.2 create a config class which initializes a new bean named topic 
		3.3 also create a new class which will send the message with the help of kafkatemplate
		3.4 with the help of a api we will get the details through controller and call the method with the message which consists of this send message function
		Message<OrderEvent> message = MessageBuilder.withPayload(event)
					.setHeader(KafkaHeaders.TOPIC, topic.name())
					.build();

Step 4 In the Stock service which is the consumer
		4.1. Initialise application properties with kafkaesque config, deserialization for key, value, but also the group id and offset value=Earliest.
		4.2 just use KafkaListener on the topic and group id and get the event
