package com.roadhog.config;

import com.roadhog.job.TestJob01;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 第一种：Simple类型
 * 将该类标记为配置文件
 * 创建 JobDetail
 * 创建 SimpleTrigger
 */
@Configuration
public class SampleScheduler {

    @Bean
    public JobDetail getJobDetail() {
        return JobBuilder.newJob(TestJob01.class)  // JobBuilder构建任务
                .withIdentity("saiJob1")  // 给该任务起个名字
                .storeDurably()  // 即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }

    @Bean
    public SimpleTrigger getTrigger() {
        SimpleScheduleBuilder scheduleBuilder =
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();  // 创建SimpleScheduleBuilder，并每2秒执行一次
        return TriggerBuilder.newTrigger()
                .forJob(getJobDetail())  // 给Trigger绑定Job
                .withIdentity("saiTrigger1")  // 给该触发器起个名字
                .withSchedule(scheduleBuilder)  // 将该触发器添加到创建好的调度器中
                //.startAt(new Date())  // 开始时间
                //.endAt(new Date())  // 结束时间
                .build();
    }

}
