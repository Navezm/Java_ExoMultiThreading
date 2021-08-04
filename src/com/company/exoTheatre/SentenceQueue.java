package com.company.exoTheatre;

import java.util.LinkedList;

public class SentenceQueue {

    private LinkedList<String> list = new LinkedList<>();

    public synchronized void add(String sentence) {
         if (list.size() >= 10) {
             System.out.println(Thread.currentThread().getName() + " est en attente la liste est pleine");
             while (list.size() >= 10) {
                 try {
                     wait();
                 } catch (InterruptedException e) {
                     return;
                 }
             }
             System.out.println(Thread.currentThread().getName() + " reprend et place sa phrase");
         }
         list.add(sentence);
         notifyAll();
    }

    public synchronized String getSentence() {
        if (list.size() == 0) {
            System.out.println(Thread.currentThread().getName() + " est en attente il n'y a pas de phrase");
            while (list.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    return "";
                }
            }
            System.out.println(Thread.currentThread().getName() + " reprend et prend une phrase");
        }
        String sentence = list.getFirst();
        list.removeFirst();
        notifyAll();
        return sentence;
    }

}
