/*
package com.lockdown.learning.userservice.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class MongoConfig extends AbstractMongoClientConfiguration{

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.password}")
    private String pass;

    @Value("${spring.data.mongodb.username}")
    private String uname;

    @Value("${spring.data.mongodb.database}")
    private String db;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Override
    public MongoClient mongoClient() {
        StringBuilder connString = new StringBuilder();
        connString.append("mongodb://")
                .append(uname)
                .append(":")
                .append(pass)
                .append("@")
                .append(host)
                .append(":")
                .append(port)
                .append("/")
                .append(db);

        log.info("conn:" + connString.toString());
        ConnectionString connectionString = new ConnectionString(connString.toString());
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return this.db;
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("com.lockdown.learning.userservice.repository");
    }
}
*/
