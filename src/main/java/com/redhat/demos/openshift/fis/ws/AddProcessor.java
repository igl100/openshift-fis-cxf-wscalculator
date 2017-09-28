package com.redhat.demos.openshift.fis.ws;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.redhat.fuse.demos.ws.wsadd.AddDTO;
import com.redhat.fuse.demos.ws.wsadd.AddResult;

public class AddProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		AddDTO dto = exchange.getIn().getBody(AddDTO.class);
		int res = dto.getOper1()-dto.getOper2();
		AddResult result = new AddResult();
		result.setResult(res);
		exchange.getIn().setBody(result);
	}

}
