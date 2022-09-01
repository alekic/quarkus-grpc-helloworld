package com.example.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreeterServiceTest {

    @GrpcClient("test")
    GreeterGrpc.GreeterBlockingStub client;

    @Test
    public void shouldReturnDefaultMessage() {
        HelloRequest request = HelloRequest.newBuilder().build();

        HelloResponse response = client.sayHello(request);

        assertEquals(response.getMessage(), "Hello, World!");
    }

    @Test
    public void shouldReturnPersonalizedMessage() {
        HelloRequest request = HelloRequest.newBuilder().setName("Quarkus").build();

        HelloResponse response = client.sayHello(request);

        assertEquals(response.getMessage(), "Hello, Quarkus!");
    }

}
