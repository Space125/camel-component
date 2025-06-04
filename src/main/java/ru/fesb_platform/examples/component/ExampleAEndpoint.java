package ru.fesb_platform.examples.component;

import org.apache.camel.*;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;
import org.apache.camel.support.DefaultEndpoint;

@UriEndpoint(scheme = "example-a", syntax = "example-a:optional:required", title = "Example A", firstVersion = "1.0.0", category = Category.CORE)
public class ExampleAEndpoint extends DefaultEndpoint {

    @UriPath(displayName = "required", description = "This is required URI path parameter")
    @Metadata(required = true)
    private String required;

    @UriPath(displayName = "optional", description = "This is optional URI path parameter")
    private String optional;

    @UriParam(displayName = "param1", label = "consumer,producer", description = "This is required URI parameter")
    @Metadata(required = true)
    private String param1;

    @UriParam(displayName = "param2", label = "consumer", description = "This is consumer only URI parameter")
    private String param2;

    @UriParam(displayName = "param3", label = "producer", description = "This is producer only URI parameter")
    private String param3;

    @UriParam(displayName = "param4", description = "This is optional URI parameter with default value", defaultValue = "The default value")
    private String param4;

    @UriParam(displayName = "param5", description = "This is optional URI parameter that requires bean")
    private ExampleAConfiguration param5;

    @UriParam(displayName = "param6", label = "advanced", description = "This is advanced URI parameter")
    private String param6;

    public ExampleAEndpoint(String endpointUri, Component component) {
        super(endpointUri, component);
    }

    @Override
    public Producer createProducer() throws Exception {
        return new ExampleAProducer(this);
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        return new ExampleAConsumer(this, processor);
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    public ExampleAConfiguration getParam5() {
        return param5;
    }

    public void setParam5(ExampleAConfiguration param5) {
        this.param5 = param5;
    }

    public String getParam6() {
        return param6;
    }

    public void setParam6(String param6) {
        this.param6 = param6;
    }
}
