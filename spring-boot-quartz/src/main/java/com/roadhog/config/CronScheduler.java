package com.roadhog.config;

import com.roadhog.job.TestJob01;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 第二种：Cron类型
 * 将该类标记为配置文件
 * 创建 JobDetail
 * 创建 CronTrigger
 */
@Configuration
public class CronScheduler {

    @Bean
    public JobDetail getJobDetail2() {
        return JobBuilder.newJob(TestJob01.class)  // JobBuilder构建任务
                .withIdentity("saiJob2")  // 给该任务起个名字
                .storeDurably()  // 即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }

    @Bean
    public CronTrigger getTrigger2() {
        CronScheduleBuilder cronScheduleBuilder =
                CronScheduleBuilder.cronSchedule("0/5 * * * * ?");  // 创建SimpleScheduleBuilder，并每2秒执行一次
        return TriggerBuilder.newTrigger()  // TriggerBuilder 构建 Trigger
                .forJob(getJobDetail2())  // 给Trigger绑定Job
                .withIdentity("saiTrigger2")  // 给该触发器起个名字
                .withSchedule(cronScheduleBuilder)  // 将该触发器添加到创建好的调度器中
                .startNow()  // 现在开始执行
                //.startAt(new Date())  // 开始时间
                //.endAt(new Date())  // 结束时间
                .build();
    }
}

