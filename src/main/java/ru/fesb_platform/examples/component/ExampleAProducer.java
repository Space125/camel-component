package ru.fesb_platform.examples.component;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultProducer;

public class ExampleAProducer extends DefaultProducer {

    public ExampleAProducer(Endpoint endpoint) {
        super(endpoint);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody("Hello World from ExampleAProducer");
    }
}
