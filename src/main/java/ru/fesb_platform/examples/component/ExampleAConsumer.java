package ru.fesb_platform.examples.component;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.support.DefaultConsumer;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExampleAConsumer extends DefaultConsumer {

    private ScheduledExecutorService executor;

    public ExampleAConsumer(Endpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }


    @Override
    protected void doStart() throws Exception {
        super.doStart();

        executor = getEndpoint().getCamelContext().getExecutorServiceManager().newSingleThreadScheduledExecutor(this, "ExampleAConsumer");
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Exchange exchange = getEndpoint().createExchange();
                exchange.getIn().setBody("Hello World from ExampleAConsumer");
                try {
                    getProcessor().process(exchange);
                } catch (Exception ignore) {
                    // Do nothing
                }
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

    @Override
    protected void doStop() throws Exception {
        super.doStop();

        if (executor != null) {
            executor.shutdownNow();
        }
    }
}
