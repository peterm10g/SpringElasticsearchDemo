package com.discoversdk.config;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author : Shubham Aggarwal
 * @since : 15/04/17
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.discoversdk.model")
@ComponentScan(basePackages = "com.discoversdk")
public class DataConfig {

    @Value("{spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    private static Logger logger = LoggerFactory.getLogger(DataConfig.class);

    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder().clusterName(clusterName);
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        final Settings.Builder elasticsearchSettings =
                Settings.settingsBuilder().put("http.enabled", "true")
                        .put("index.number_of_shards", "1");

        return new ElasticsearchTemplate(nodeBuilder()
                .local(true)
                .settings(elasticsearchSettings.build())
                .node()
                .client());
    }
}
