package com.oops.concept;

import java.util.PriorityQueue;
import java.util.Queue;

public class MainForProdAndConsumer {

	public static void main(String[] args) {
		Queue<Integer> input = new PriorityQueue<>(10);
		Thread producer = new Thread(new Producer(input));
		Thread consumer = new Thread(new Consumer(input));
		producer.start();
		consumer.start();
	}

}
