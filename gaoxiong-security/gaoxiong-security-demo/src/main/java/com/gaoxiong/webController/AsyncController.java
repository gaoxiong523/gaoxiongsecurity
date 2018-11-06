package com.gaoxiong.webController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author gaoxiong
 * @ClassName AsyncController
 * @Description 多线程提高rest服务的性能
 * @date 2018/11/4 20:58
 */
@RestController
@Slf4j
public class AsyncController {

    @RequestMapping("/order")
    public Callable<String> order(){
        log.info("主线程开始");
        Callable<String> callable = () -> {

            log.info("副线程开始");
            Thread.sleep(1000);
            log.info("副线程结束");
            return "success";
        };
        log.info("主线程结束");
        return callable;
    }

}
