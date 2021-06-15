package com.pichincha.backend.test.util;

import static org.springframework.http.HttpEntity.EMPTY;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import org.apiguardian.api.API;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class ApiConsumerTest {

  @Spy
  RestTemplate restTemplate;
  @InjectMocks
  ApiConsumer apiConsumer;
  MockRestServiceServer mockServer;
  String url;

  @BeforeEach
  void setUp(){
    url = "http://test";
    mockServer = MockRestServiceServer.createServer(restTemplate);
  }

@Test
  void shouldThrowApiBodyExceptionWhenMissingBodyInResponse(){
    mockServer.expect(requestTo(url))
        .andExpect(method(GET))
        .andRespond(withStatus(OK));apiConsumer.consumeApiRest(url,GET,EMPTY, ParameterizedTypeReference.forType(String.class));
}



}