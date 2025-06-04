package ru.fesb_platform.examples.component;

import org.apache.camel.Endpoint;
import org.apache.camel.spi.Configurer;
import org.apache.camel.spi.annotations.Component;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

@Configurer
@Component("example-a")
public class ExampleA extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        ExampleAEndpoint endpoint = new ExampleAEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
