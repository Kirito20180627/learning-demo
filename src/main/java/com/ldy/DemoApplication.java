package com.ldy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableRetry
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums, 3);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collect = Arrays.stream(strs).collect(
                Collectors.groupingBy(str -> {
                    int[] counter = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        counter[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < counter.length; i++) {
                        if (counter[i] != 0) {
                            sb.append((char) counter[i] + 'a');
                            sb.append(counter[i]);
                        }
                    }
                    return sb.toString();
                })
        );
        return new ArrayList<>(collect.values());
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        result[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty()) {
                if (nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.addFirst(i);
            }
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            result[i + 1 - k] = nums[queue.peekFirst()];
        }
        return result;
    }

    public static void test() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                8,
                16,
                200,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100));
        threadPoolExecutor.submit(() -> System.out.println("test"));

    }

}
