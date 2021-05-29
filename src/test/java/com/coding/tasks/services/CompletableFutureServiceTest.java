package com.coding.tasks.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CompletableFutureServiceTest {

	@Test
	public void testCompletableFuture() {
		assertNotNull(new CompletableFutureService().completableFuture());
	}
}
