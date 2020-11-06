package com.lung.game.task;

import com.lung.game.cache.UserPlayerCache;
import com.lung.game.cache.UserResourceCache;
import com.lung.game.domain.UserResource;
import com.lung.game.mixed.CronConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/6 - 18:23
 * @implSpec 游戏资源产出任务
 */
@Slf4j
@Component
public class UserResourceOutPutTask implements SchedulingConfigurer {

    @Resource
    UserPlayerCache userPlayerCache;
    @Resource
    UserResourceCache userResourceCache;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(getScheduleJob(), getTrigger());
    }

    private Runnable getScheduleJob() {
        return new Runnable() {
            @Override
            public void run() {
                // 业务
                userPlayerCache.findAll().forEach(
                        userProfile -> {
                            Optional<UserResource> userResource = userResourceCache.findById(userProfile.getId());
                            if (!userResource.isPresent()) {
                                if (log.isDebugEnabled()) {
                                    log.debug("user {} has no resources output", userProfile.getId());
                                }
                            }else {
                                UserResource resources = userResource.get();
                                resources.increment();
                                userResourceCache.save(resources);
                            }
                        }
                );
            }
        };
    }

    private Trigger getTrigger() {
        return new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 触发器
                CronTrigger trigger = new CronTrigger(getCron());
                return trigger.nextExecutionTime(triggerContext);
            }
        };
    }

    private String getCron() {
        return CronConfiguration.OUTPUT_RESOURCE;
    }

}
