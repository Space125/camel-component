package ru.fesb_platform.examples.component;


import org.apache.camel.*;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;
import org.apache.camel.support.DefaultEndpoint;

@UriEndpoint(scheme = "example-b", syntax = "example-b:something", title = "Example B", producerOnly = true, firstVersion = "1.0.0", category = Category.CORE)
public class ExampleBEndpoint extends DefaultEndpoint {

    @UriPath(description = "something")
    private String something;

    @UriParam(description = "paramA")
    private String paramA;

    @UriParam(description = "paramB")
    private String paramB;

    public ExampleBEndpoint(String endpointUri, Component component) {
        super(endpointUri, component);
    }

    @Override
    public Producer createProducer() throws Exception {
        return new ExampleBProducer(this);
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public String getParamA() {
        return paramA;
    }

    public void setParamA(String paramA) {
        this.paramA = paramA;
    }

    public String getParamB() {
        return paramB;
    }

    public void setParamB(String paramB) {
        this.paramB = paramB;
    }
}
