package com.pichincha.backend.test.util;

import static com.pichincha.backend.test.Constants.BODY_NOT_FOUND;

import com.pichincha.backend.test.exception.ApiBodyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiConsumer {


  @Autowired
  RestTemplate restTemplate;

  public <T> T consumeApiRest(String url, HttpMethod method, HttpEntity body,
      ParameterizedTypeReference<T> parameterizedTypeReference) {
    ResponseEntity<T> response = restTemplate.exchange(url, method, body,
        parameterizedTypeReference);
    if (response.hasBody()) {
      return response.getBody();
    }
    throw new ApiBodyException(BODY_NOT_FOUND);
  }

}
