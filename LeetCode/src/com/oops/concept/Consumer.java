package com.oops.concept;

import java.util.Queue;

public class Consumer implements Runnable {
	private Queue<Integer> input;

	public Consumer(Queue<Integer> input) {
		this.input = input;
	}

	@Override
	public void run() {
		synchronized (input) {
			if (input.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				while (!input.isEmpty()) {
					System.out.println("Consuming Data...." + input.poll());
				}
				notify();
			}
		}
	}
}
