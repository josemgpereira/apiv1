package com.jp.oracle.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.jp.oracle.models"})
@EnableJpaRepositories(basePackages = {"com.jp.oracle.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}