package com.oops.concept;

import java.util.Queue;

public class Producer implements Runnable {
	private Queue<Integer> input;

	public Producer(Queue<Integer> input) {
		this.input = input;
	}

	@Override
	public void run() {
		synchronized (input) {
			if (!input.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				int count = 1;
				while (input.isEmpty()) {
					System.out.println("Producing Data...." + count);
					input.add(count);
					count++;
				}
				notify();
			}
		}
	}
}
