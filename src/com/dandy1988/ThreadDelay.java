package com.dandy1988;

public class ThreadDelay extends Thread{
    private Thread thread;
    private long delaySeconds;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long now = System.currentTimeMillis();

        while ((now - start) <= delaySeconds*1000) {
            now = System.currentTimeMillis();
        }
    }

    public long getDelaySeconds() {
        return delaySeconds;
    }

    public void setDelaySeconds(long delaySeconds) {
        this.delaySeconds = delaySeconds;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public ThreadDelay(Thread thread, long delaySeconds) {
        this.thread = thread;
        this.delaySeconds = delaySeconds;
    }
}
