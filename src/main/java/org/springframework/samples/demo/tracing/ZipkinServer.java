/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.demo.tracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

import org.apache.log4j.Logger;
import java.util.Arrays;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * @author wdongyu
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class ZipkinServer {

    private static final Logger logger = Logger.getLogger("test");

    public static void main(String[] args) {
        //logger.info(Arrays.toString(((URLClassLoader)ZipkinServer.class.getClassLoader()).getURLs()));
        //ProtectionDomain pd = EnableZipkinServer.class.getProtectionDomain();
        //CodeSource cs = pd.getCodeSource();
        //logger.info(cs.getLocation());
        SpringApplication.run(ZipkinServer.class, args);
    }
}
