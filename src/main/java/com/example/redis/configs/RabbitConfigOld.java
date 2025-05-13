//package com.example.redis.configs;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitConfigOld {
//
//    public static final String EXCHANGE = "transaction.exchange";
//    public static final String ROUTING_KEY = "transaction.key";
//    public static final String QUEUE = "transaction.queue";
//
//    @Bean
//    public DirectExchange directExchange() {
//        return new DirectExchange(EXCHANGE);
//    }
//
//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE);
//    }
//
//    @Bean
//    public Binding binding(Queue queue, DirectExchange directExchange) {
//        return BindingBuilder.bind(queue).to(directExchange).with(ROUTING_KEY);
//    }
//
//    // Jackson converter
//    @Bean
//    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    // RabbitTemplate with Jackson
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory factory, Jackson2JsonMessageConverter converter) {
//        RabbitTemplate template = new RabbitTemplate(factory);
//        template.setMessageConverter(converter);
//        return template;
//    }
//
//}
