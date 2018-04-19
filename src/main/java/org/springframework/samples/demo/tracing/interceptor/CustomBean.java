package org.springframework.samples.demo.tracing.interceptor;

import zipkin.Span;
import zipkin.reporter.AsyncReporter;
import zipkin.reporter.Reporter;
import zipkin.reporter.Sender;
import zipkin.reporter.okhttp3.OkHttpSender;
import com.github.kristofa.brave.Brave;
import com.github.kristofa.brave.LoggingReporter;
import com.github.kristofa.brave.http.DefaultSpanNameProvider;
import com.github.kristofa.brave.http.SpanNameProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBean {
    /** Configuration for how to send spans to Zipkin */
    @Bean Sender sender() {
        return OkHttpSender.create("http://localhost:9411/api/v1/spans");
        //return LibthriftSender.create("127.0.0.1");
        // return KafkaSender.create("127.0.0.1:9092");
    }

    /** Configuration for how to buffer spans into messages for Zipkin */
    @Bean Reporter<Span> reporter() {
        //return new LoggingReporter();
        // uncomment to actually send to zipkin!
        return AsyncReporter.builder(sender()).build();
    }
    
    @Bean Brave brave() {
        return new Brave.Builder("tracing-server").reporter(reporter()).build();
    }

    // decide how to name spans. By default they are named the same as the http method.
    @Bean SpanNameProvider spanNameProvider() {
        return new DefaultSpanNameProvider();
    }
}