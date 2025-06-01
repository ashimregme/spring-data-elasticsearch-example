package com.example.springdataelasticsearchexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import java.net.InetSocketAddress;

@Configuration
public class ESConfiguration extends ElasticsearchConfiguration {
    @Value("${es.scheme}")
    private String scheme;
    @Value("${es.host}")
    private String host;
    @Value("${es.port}")
    private int port;

    @Override
    public ClientConfiguration clientConfiguration() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(host, port);
        return ClientConfiguration.builder()
                .connectedTo(inetSocketAddress)
                .usingSsl(scheme.equals("https"))
                .build();
    }
}