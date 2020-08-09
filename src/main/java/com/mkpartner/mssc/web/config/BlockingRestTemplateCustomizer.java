package com.mkpartner.mssc.web.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private Integer maxTotalConnection;
    private Integer defaultMaxTotalConnection;
    private Integer connectionRequestTimeout;
    private Integer socketTimeout;

    public BlockingRestTemplateCustomizer(@Value("${sfg.maxTotalConnection}")Integer maxTotalConnection,
                                          @Value("${sfg.defaultMaxTotalConnection}")Integer defaultMaxTotalConnection,
                                          @Value("${sfg.connectionRequestTimeout}")Integer connectionRequestTimeout,
                                          @Value("${sfg.socketTimeout}")Integer socketTimeout){
        this.maxTotalConnection = maxTotalConnection;
        this.defaultMaxTotalConnection = defaultMaxTotalConnection;
        this.connectionRequestTimeout = connectionRequestTimeout;
        this.socketTimeout = socketTimeout;
    }

    public ClientHttpRequestFactory clientHttpRequestFactory() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotalConnection);
        connectionManager.setDefaultMaxPerRoute(defaultMaxTotalConnection);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout)
                .build();

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Override
    public void customize(RestTemplate restTemplate){
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}
