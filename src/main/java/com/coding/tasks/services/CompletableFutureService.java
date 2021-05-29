package com.coding.tasks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CompletableFutureService {

	/**
	 * Calls Median House Price, weather and employment percent of city API's
	 * 
	 * @return String
	 */
	public String completableFuture() {
		List<CompletableFuture<String>> futures = new ArrayList<>();

		futures.add(getMedianHousePrice());
		futures.add(getWeather());
		futures.add(getCityEmployment());

		CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

		AtomicReference<String> result = new AtomicReference<>();

		futures.forEach(future -> {
			try {
				result.getAndSet((null != result.get()) ? result.get() + future.get() + "," : future.get() + ",");
			} catch (InterruptedException | ExecutionException e) {
				log.error("Interrupted Exception", e);
			}
		});
		return result.get();
	}

	@Async("asyncExecutor")
	private CompletableFuture<String> getMedianHousePrice() {
		// TODO Service call to get median house price
		return CompletableFuture.completedFuture("MedianHousePrice :: " + 10.11d);
	}

	@Async("asyncExecutor")
	private CompletableFuture<String> getWeather() {
		// TODO Service call to get Weather
		return CompletableFuture.completedFuture("Weather :: " + 85.5);
	}

	@Async("asyncExecutor")
	private CompletableFuture<String> getCityEmployment() {
		// TODO Service call to get Weather
		return CompletableFuture.completedFuture("Employment Percentage :: " + 65.5);
	}

}
