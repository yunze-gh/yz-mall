package com.yz.mall.sys.demo;

import com.yz.mall.sys.business.task.AbstractSysPendingTasksQueueConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 供应链管理-采购申请待办
 * @author yunze
 * @date 2025/1/21 22:42
 */
@Configuration
public class ScmPurchaseQueueConfig extends AbstractSysPendingTasksQueueConfig {

    public static final String QUEUE_NAME = "scm_purchase";
    private static final String START_KEY = QUEUE_NAME + "_start_key";
    private static final String END_KEY = QUEUE_NAME + "_end_key";

    @Bean("queueScmPurchaseStart")
    @Override
    protected Queue queueStart() {
        return new Queue(QUEUE_NAME + "_start");
    }

    @Bean("queueScmPurchaseEnd")
    @Override
    protected Queue queueEnd() {
        return new Queue(QUEUE_NAME + "_end");
    }

    @Bean("bindQueueScmPurchaseStartToPmsExchange")
    @Override
    protected Binding bindQueueStartToPmsExchange() {
        return BindingBuilder.bind(queueStart()).to(super.setSysTaskTopicExchange()).with(START_KEY);
    }

    @Bean("bindQueueScmPurchaseEndToPmsExchange")
    @Override
    protected Binding bindQueueEndToPmsExchange() {
        return BindingBuilder.bind(queueEnd()).to(super.setSysTaskTopicExchange()).with(END_KEY);
    }
}
