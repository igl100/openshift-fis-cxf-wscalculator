/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package com.redhat.demos.openshift.fis;

import org.apache.camel.CamelContext;
import org.apache.camel.component.cxf.CxfComponent;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.redhat.demos.openshift.fis.ws.AddEndpoint;
import com.redhat.demos.openshift.fis.ws.MultiplyEndpoint;
import com.redhat.demos.openshift.fis.ws.SumEndpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public CxfEndpoint sumEndpoint(final CamelContext camelContext) {
    	final CxfComponent cxfComponent = new CxfComponent(camelContext);
        CxfEndpoint endpoint = new CxfEndpoint("", cxfComponent);
        endpoint.setServiceClass(SumEndpoint.class);
        endpoint.setBus(bus);
        endpoint.setAddress("/sum");
        endpoint.setDataFormat(DataFormat.POJO);
        return endpoint;
    }
    
    @Bean
    public CxfEndpoint addEndpoint(final CamelContext camelContext) {
    	final CxfComponent cxfComponent = new CxfComponent(camelContext);
        CxfEndpoint endpoint = new CxfEndpoint("", cxfComponent);
        endpoint.setServiceClass(AddEndpoint.class);
        endpoint.setBus(bus);
        endpoint.setAddress("/add");
        endpoint.setDataFormat(DataFormat.POJO);
        return endpoint;
    }
    
    @Bean
    public CxfEndpoint multiplyEndpoint(final CamelContext camelContext) {
    	final CxfComponent cxfComponent = new CxfComponent(camelContext);
        CxfEndpoint endpoint = new CxfEndpoint("", cxfComponent);
        endpoint.setServiceClass(MultiplyEndpoint.class);
        endpoint.setBus(bus);
        endpoint.setAddress("/multiply");
        return endpoint;
    }
}
