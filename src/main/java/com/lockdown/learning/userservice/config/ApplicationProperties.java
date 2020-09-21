package com.lockdown.learning.userservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="application", ignoreUnknownFields = true)
public class ApplicationProperties {
}
