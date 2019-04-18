package com.sse.attemper.executor.task;

import com.sse.attemper.executor.task.internal.HttpTask;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Short Connection with Async-Callback
 */
public class AsyncHttpTask extends HttpTask {

    @Override
    protected void executeWithUrl(String url, String jobName, DelegateExecution execution) {
        System.out.println("start execution:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ":" + execution.getCurrentActivityName());
        WebClient webClient = buildWebClient(url, 10);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("executionId", execution.getId());
        String result = webClient
                .method(HttpMethod.POST)
                .uri("/" + jobName + "/" + execution.getCurrentActivityId())
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(hashMap)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(result);
        synchronized (execution.getId().intern()) {
            try {
                execution.getId().intern().wait(120000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end execution:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ":" + execution.getCurrentActivityName());
    }
}