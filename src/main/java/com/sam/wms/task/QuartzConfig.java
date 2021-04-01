package com.sam.wms.task;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sam
 * date:2021.03.2021/3/15
 * time:12:16
 */

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printTimeJobDetail(){
        return JobBuilder.newJob(ProductTask.class)//PrintTimeJob我们的业务类
                .withIdentity("ProductTask")//可以给该JobDetail起一个id
                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }

    @Bean
    public JobDetail OrderDownloadJobDetail(){
        return JobBuilder.newJob(OrderTask.class)
                .withIdentity("OrderATask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printTimeJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
        return  TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail())//关联上述的JobDetail
                .withIdentity("ProductTask")//给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    @Bean
    public Trigger printTimeJobTrigger2() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
        return  TriggerBuilder.newTrigger()
                .forJob(OrderDownloadJobDetail())
                .withIdentity("OrderDownload")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}
