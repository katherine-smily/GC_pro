/*
 * @test
 * @bug 1234567
 * @summary Simple example test
 * @run main -Xmx1G -XX:+UseG1GC -XX:+UnlockDiagnosticVMOptions LRUCache_jtreg_test
 */

package com.example;

import java.util.Random;

public class LRUCache_jtreg_test {
    private static final int CACHE_SIZE = 400000;
    private static final int TEST_DURATION_MS = 10000;  // 10 seconds
    // private static final int test_size = 40000000;  
    private static final int test_size = 100000000;  

    public static void main(String[] args) throws Exception {
        LRUCache cache = new LRUCache(CACHE_SIZE);
        Random random = new Random();
        long beginTime=System.currentTimeMillis();
        // long endTime = System.currentTimeMillis() + TEST_DURATION_MS;
        // while (System.currentTimeMillis() < endTime) {
        //     int key = random.nextInt(10 * CACHE_SIZE)%10;
        //     cache.put(key, new byte[1024]); // 1KB value
        // }
        int cnt=0;
        // while (System.currentTimeMillis() < endTime) {
        while (cnt++<test_size) {
            int key = random.nextInt(10 * CACHE_SIZE);
            // int key = cnt*47%3089;
            // cache.put(key, new byte[1024]); // 1KB value
            // cache.put(key, new byte[65536]); // 1KB value
            cache.put(key, new byte[1024]); // 8KB value
            cnt++;
            // if(cnt%1000000==0){
            //     System.gc();
            // }
        }
        // System.err.println(cnt);
        long total_time=System.currentTimeMillis()-beginTime;
        System.out.println("total_time:"+ total_time+". Finish LRUCache test!");
        // System.gc();
    }


}
